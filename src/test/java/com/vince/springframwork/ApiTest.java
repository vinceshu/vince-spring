package com.vince.springframwork;

import com.vince.springframwork.bean.UserService;
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
        //1、BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2、注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3、获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String s = userService.queryUser();
        System.out.printf(s);
    }

}
