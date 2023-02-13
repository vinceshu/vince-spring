package com.vince.springframework.core.io;

/**
 * @author vinceshu
 * @data 2023/2/13 23:19
 * @description 资源文件加载器
 */
public interface ResourceLoader{

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
