package com.vince.springframwork.bean;

/**
 * @author vinceshu
 * @data 2023/2/11 21:13
 * @description
 */
public class UserService {

    private String uid;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uid);
    }

    public String getuId() {
        return uid;
    }

    public void setuId(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
