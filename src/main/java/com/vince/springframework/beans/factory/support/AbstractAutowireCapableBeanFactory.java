package com.vince.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanPostProcessor;
import com.vince.springframework.beans.factory.config.BeanReference;
import com.vince.springframework.beans.PropertyValue;
import com.vince.springframework.beans.PropertyValues;

import java.lang.reflect.Constructor;

/**
 * @author vinceshu
 * @data 2023/2/11 21:54
 * @description
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object beanInstance = null;
        try {
            //创建并获取bean实例对象
            beanInstance = createBeanInstance(beanDefinition, beanName, args);
            //给bean对象填充属性
            applyPropertyValues(beanName, beanInstance, beanDefinition);
            //执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            beanInstance = initializeBean(beanName, beanInstance, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //创建单例bean对象进行缓存
        addSingleton(beanName, beanInstance);
        return beanInstance;
    }

    /**
     * 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
     * @param beanName
     * @param beanInstance
     * @param beanDefinition
     * @return
     */
    private Object initializeBean(String beanName, Object beanInstance, BeanDefinition beanDefinition) {
        //1、执行BeanPostProcessor Before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(beanInstance, beanName);

        //待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);
        
        //2、执行BeanPostProcessor After处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(beanInstance, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
        }
        return result;
    }

    /**
     * 创建并获取bean实例对象
     * @param beanDefinition bean定义信息
     * @param beanName bean名称
     * @param args bean属性参数
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    /**
     * 给bean对象填充属性
     * @param beanName bean名称
     * @param beanInstance bean实例
     * @param beanDefinition bean定义信息
     */
    protected void applyPropertyValues(String beanName, Object beanInstance, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(beanInstance, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
