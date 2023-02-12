package com.vince.springframwork.factory.config;

/**
 * @author vinceshu
 * @data 2023/2/12 22:57
 * @description
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
