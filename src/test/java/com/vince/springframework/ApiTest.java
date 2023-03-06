package com.vince.springframework;

import cn.hutool.core.io.IoUtil;
import com.vince.springframework.bean.UserService;
import com.vince.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.vince.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.vince.springframework.common.MyBeanFactoryPostProcessor;
import com.vince.springframework.common.MyBeanPostProcessor;
import com.vince.springframework.context.support.ClassPathXmlApplicationContext;
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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml_after() {
        //1、初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        //2、获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo();
        System.out.println(userInfo);
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
