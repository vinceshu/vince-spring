package com.vince.springframework.context;

import com.vince.springframework.beans.BeansException;

/**
 * @author vinceshu
 * @data 2023/2/15 00:08
 * @description
 */
public interface ConfigurableApplicationContext extends ApplicationContext{


    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
