package com.vince.springframework.beans.factory;

import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanPostProcessor;
import com.vince.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author vinceshu
 * @data 2023/2/14 23:49
 * @description
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
