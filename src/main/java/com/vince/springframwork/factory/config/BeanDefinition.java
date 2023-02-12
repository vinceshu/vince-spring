package com.vince.springframwork.factory.config;

import com.vince.springframwork.factory.property.PropertyValues;

/**
 * @author vinceshu
 * @data 2023/2/11 20:57
 * @description 定义Bean信息
 */
public class BeanDefinition {

    /**
     * bean的类
     */
    private Class<?> beanClass;

    /**
     * bean的属性值
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
