package com.vince.springframwork;

import com.vince.springframwork.bean.UserService;
import com.vince.springframwork.factory.config.BeanDefinition;
import com.vince.springframwork.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author vinceshu
 * @data 2023/2/11 21:24
 * @description
 */
public class ApiTest {


    /**
     * 测试基础bean工厂
     */
    @Test
    public void test_BeanFactory() {
        //1、初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3、第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String userName = userService.queryUserName();
        System.out.println(userName);
        //4、第二次获取bean from singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        String userName2 = userService_singleton.queryUserName();
        System.out.println(userName2);
    }

}
