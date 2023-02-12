package com.vince.springframwork.bean;

/**
 * @author vinceshu
 * @data 2023/2/11 21:13
 * @description
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserName() {
        return name;
    }
}
