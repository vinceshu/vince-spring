package com.vince.springframwork;

import com.vince.springframwork.exception.BeansException;
import com.vince.springframwork.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vinceshu
 * @data 2023/2/11 20:59
 * @description bean工厂
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
