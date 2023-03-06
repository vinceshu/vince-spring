package com.vince.springframework.context.support;

import com.vince.springframework.beans.BeansException;

/**
 * @author vinceshu
 * @data 2023/2/15 22:58
 * @description 对外给用户提供的应用上下文方法
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}
