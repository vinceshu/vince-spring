package com.vince.springframwork.factory.support;

import com.vince.springframwork.exception.BeansException;
import com.vince.springframwork.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author vinceshu
 * @data 2023/2/12 21:05
 * @description 实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * 实例化接口
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
