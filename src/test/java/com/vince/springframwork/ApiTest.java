package com.vince.springframwork;

import com.vince.springframwork.bean.UserDao;
import com.vince.springframwork.bean.UserService;
import com.vince.springframwork.factory.config.BeanDefinition;
import com.vince.springframwork.factory.config.BeanReference;
import com.vince.springframwork.factory.property.PropertyValue;
import com.vince.springframwork.factory.property.PropertyValues;
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
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3、给bean设置属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //4、userService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5、userService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String s = userService.queryUserInfo();
        System.out.println(s);
    }

}
