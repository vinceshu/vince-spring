package com.vince.springframework.beans;

/**
 * @author vinceshu
 * @data 2023/2/11 22:02
 * @description
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
