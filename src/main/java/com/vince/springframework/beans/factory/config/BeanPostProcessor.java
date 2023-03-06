package com.vince.springframework.beans.factory.config;

import com.vince.springframework.beans.BeansException;

/**
 * @author vinceshu
 * @data 2023/2/14 23:41
 * @description 在bean实例化前后对bean做扩展
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean对象执行初始化方法前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;


}
