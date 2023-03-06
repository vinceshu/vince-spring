package com.vince.springframework.beans.factory.support;

import com.vince.springframework.beans.factory.BeanFactory;
import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanPostProcessor;
import com.vince.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinceshu
 * @data 2023/2/11 21:52
 * @description
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 获取bean 模版方法
     * @param name
     * @param args
     * @return
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        //单例bean已有，直接返回
        Object singletonBean = getSingleton(name);
        if (singletonBean != null) {
            return (T)singletonBean;
        }
        //没有重新创建并返回
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
