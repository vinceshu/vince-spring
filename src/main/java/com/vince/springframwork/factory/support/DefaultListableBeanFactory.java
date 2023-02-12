package com.vince.springframwork.factory.support;

import com.vince.springframwork.exception.BeansException;
import com.vince.springframwork.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinceshu
 * @data 2023/2/11 21:53
 * @description
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("no bean named '" + beanName + "' is defined" );
        return beanDefinition;
    }


}
