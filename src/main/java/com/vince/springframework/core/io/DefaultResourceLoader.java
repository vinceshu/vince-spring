package com.vince.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author vinceshu
 * @data 2023/2/13 23:20
 * @description 资源加载器实现类
 */
public class DefaultResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        //以classpath开头，走ClassPathResource
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            //走UrlResource
            URL url = null;
            try {
                url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //异常，走系统文件
                return new FileSystemResource(location);
            }
        }
    }
}
