package com.vince.springframework.beans.factory.support;

import com.vince.springframework.beans.BeansException;
import com.vince.springframework.core.io.Resource;
import com.vince.springframework.core.io.ResourceLoader;

/**
 * @author vinceshu
 * @data 2023/2/13 23:44
 * @description bean定义读取接口
 */
public interface BeanDefinitionReader {

    /**
     * 获取bean定义注册器
     * 提供给下面3个 loadBeanDefinitions使用，包装到抽象类中，防止污染具体接口实现方法
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * 提供给下面3个 loadBeanDefinitions使用，包装到抽象类中，防止污染具体接口实现方法
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 根据资源加载bean定义
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
