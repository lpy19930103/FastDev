package com.bean;

/**
 * Created by lipy on 2017/9/26.
 */

public class LoginReq implements DataObject {
    private String loginName;
    private String password;
    private boolean rememberMe;

    public LoginReq(String loginName, String password, boolean rememberMe) {
        this.loginName = loginName;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
