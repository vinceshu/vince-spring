package com.vince.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanReference;
import com.vince.springframework.beans.PropertyValue;
import com.vince.springframework.beans.PropertyValues;

import java.lang.reflect.Constructor;

/**
 * @author vinceshu
 * @data 2023/2/11 21:54
 * @description
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubClassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object beanInstance = null;
        try {
            //创建并获取bean实例对象
            beanInstance = createBeanInstance(beanDefinition, beanName, args);
            //给bean对象填充属性
            applyPropertyValues(beanName, beanInstance, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //创建单例bean对象进行缓存
        addSingleton(beanName, beanInstance);
        return beanInstance;
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
