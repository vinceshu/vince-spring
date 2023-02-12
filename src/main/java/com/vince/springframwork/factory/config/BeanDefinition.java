package com.vince.springframwork.factory.config;

/**
 * @author vinceshu
 * @data 2023/2/11 20:57
 * @description 定义Bean信息
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return this.beanClass;
    }

}
