package com.vince.springframework.bean;

/**
 * @author vinceshu
 * @data 2023/2/11 21:13
 * @description
 */
public class UserService {

    private String uid;

    private String company;

    private String location;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uid) + "," + company + "," + location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
