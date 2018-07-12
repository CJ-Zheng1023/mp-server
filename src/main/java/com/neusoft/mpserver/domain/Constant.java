package com.neusoft.mpserver.domain;

/**
 * 常量值
 * @name fandp
 * @email fandp@neusoft.com
 */
public class Constant {
    //注册成功code码值
    private static final String SUCCESS_REGISTER="1";
    //注册失败code码值
    private static final String FAIL_REGISTER="2";
    //登录查询没有用户码值
    private static final  String NOUSER_LOGIN="2";
    //登录成功
    private static final  String SUCCESS_LOGIN="1";
    //登录查询密码错误
    private static final  String FAILPASS_LOGIN="3";

    public static String getSuccessRegister() {
        return SUCCESS_REGISTER;
    }

    public static String getFailRegister() {
        return FAIL_REGISTER;
    }

    public static String getNouserLogin() {
        return NOUSER_LOGIN;
    }

    public static String getSuccessLogin() {
        return SUCCESS_LOGIN;
    }

    public static String getFailpassLogin() {
        return FAILPASS_LOGIN;
    }
}
