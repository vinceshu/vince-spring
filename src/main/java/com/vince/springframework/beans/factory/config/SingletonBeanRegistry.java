package com.vince.springframework.beans.factory.config;

/**
 * @author vinceshu
 * @data 2023/2/11 21:52
 * @description 单例注册接口,作为缓存
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName bean名称
     * @return bean对象实例
     */
    Object getSingleton(String beanName);

}
