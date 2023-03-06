package com.vince.springframework.beans.factory;

import com.vince.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author vinceshu
 * @data 2023/2/14 23:48
 * @description
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
