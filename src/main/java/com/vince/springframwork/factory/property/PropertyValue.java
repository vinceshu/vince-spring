package com.vince.springframwork.factory.property;

/**
 * @author vinceshu
 * @data 2023/2/12 22:58
 * @description bean属性值
 */
public class PropertyValue {

    /**
     * 属性名称
     */
    private final String name;

    /**
     * 属性值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
