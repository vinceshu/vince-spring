package com.vince.springframework.common;

import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.PropertyValue;
import com.vince.springframework.beans.PropertyValues;
import com.vince.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author vinceshu
 * @data 2023/2/15 23:46
 * @description
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
