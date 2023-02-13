package com.vince.springframework.beans.factory;

import com.vince.springframework.beans.BeansException;

/**
 * @author vinceshu
 * @data 2023/2/11 20:59
 * @description bean工厂
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
