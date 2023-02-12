package com.vince.springframwork.factory.support;

import com.vince.springframwork.BeanFactory;
import com.vince.springframwork.exception.BeansException;
import com.vince.springframwork.factory.config.BeanDefinition;

/**
 * @author vinceshu
 * @data 2023/2/11 21:52
 * @description
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取bean 模版方法
     * @param name bean名称
     * @return bean对象实例
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //单例bean已有，直接返回
        Object singletonBean = getSingleton(name);
        if (singletonBean != null) {
            return singletonBean;
        }
        //没有重新创建并返回
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
