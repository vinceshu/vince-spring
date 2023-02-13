package com.vince.springframework;

import cn.hutool.core.io.IoUtil;
import com.vince.springframework.bean.UserDao;
import com.vince.springframework.bean.UserService;
import com.vince.springframework.beans.factory.config.BeanDefinition;
import com.vince.springframework.beans.factory.config.BeanReference;
import com.vince.springframework.beans.PropertyValue;
import com.vince.springframework.beans.PropertyValues;
import com.vince.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.vince.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.vince.springframework.core.io.DefaultResourceLoader;
import com.vince.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author vinceshu
 * @data 2023/2/11 21:24
 * @description
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_xml() {
        //1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、读取配置文件&注册Bean
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //3、获取Bean对象调用方法
        UserService userService = (UserService)beanFactory.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo();
        System.out.println(userInfo);
    }

    /**
     * 测试ClassPathResource
     * @throws IOException
     */
    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    /**
     * 测试FileSystem
     * @throws IOException
     */
    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/vinceshu/vince-spring/blob/spring_v5/src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
