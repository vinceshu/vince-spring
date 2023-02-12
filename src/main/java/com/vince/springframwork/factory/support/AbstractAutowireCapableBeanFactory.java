package com.vince.springframwork.factory.support;

import com.vince.springframwork.exception.BeansException;
import com.vince.springframwork.factory.config.BeanDefinition;

/**
 * @author vinceshu
 * @data 2023/2/11 21:54
 * @description
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object beanInstance = null;
        try {
            //获取bean实例对象
            //todo 此处instance有坑，如果构造函数入参对象如何处理？
            beanInstance = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //创建单例bean对象进行缓存
        addSingleton(beanName, beanInstance);
        return beanInstance;
    }
}
