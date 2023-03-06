package com.vince.springframework.beans.factory.config;

import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author vinceshu
 * @data 2023/2/14 23:38
 * @description BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
