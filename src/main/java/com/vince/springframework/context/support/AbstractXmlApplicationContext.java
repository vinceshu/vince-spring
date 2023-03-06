package com.vince.springframework.context.support;

import com.vince.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.vince.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author vinceshu
 * @data 2023/2/15 22:53
 * @description
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
