package com.vince.springframework.context.support;

import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.vince.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author vinceshu
 * @data 2023/2/15 22:26
 * @description
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
