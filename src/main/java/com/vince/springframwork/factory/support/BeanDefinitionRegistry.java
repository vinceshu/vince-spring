package com.vince.springframwork.factory.support;

import com.vince.springframwork.factory.config.BeanDefinition;

/**
 * @author vinceshu
 * @data 2023/2/11 21:53
 * @description BeanDefinition注册接口
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
