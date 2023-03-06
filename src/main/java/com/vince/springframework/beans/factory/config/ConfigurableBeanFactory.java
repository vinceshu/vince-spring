package com.vince.springframework.beans.factory.config;

import com.vince.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author vinceshu
 * @data 2023/2/14 23:40
 * @description
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
