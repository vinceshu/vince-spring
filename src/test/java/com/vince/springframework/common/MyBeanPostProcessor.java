package com.vince.springframework.common;

import com.vince.springframework.bean.UserService;
import com.vince.springframework.beans.BeansException;
import com.vince.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author vinceshu
 * @data 2023/2/15 23:47
 * @description
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：杭州");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
