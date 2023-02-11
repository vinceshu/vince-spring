package com.vince.springframwork;

/**
 * @author vinceshu
 * @data 2023/2/11 20:57
 * @description 定义Bean实例化信息
 */
public class BeanDefinition {

    private final Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return this.bean;
    }

}
