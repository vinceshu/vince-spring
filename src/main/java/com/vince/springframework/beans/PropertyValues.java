package com.vince.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinceshu
 * @data 2023/2/12 22:58
 * @description bean属性集合
 */
public class PropertyValues {

    /**
     * 定义一个集合统一放属性对象
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加一个属性对象
     * @param propertyValue
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    /**
     * 获取所有的属性对象
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性名获取属性值
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
