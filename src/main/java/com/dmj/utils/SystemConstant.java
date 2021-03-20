package com.dmj.utils;

public interface SystemConstant {
    /**
     * 加密的次数
     */
    Integer PASSWORD_COUNT = 5;
    /**
     * 登录用户保存的key
     */
    String LOGINUSER = "loginUser";
    /**
     * 成功
     */
    String SUCCESS = "success";
    /**
     * 失败
     */
    String MESSAGE = "message";
    /**
     * 是否存在
     */
    String EXIST = "exist";
    /**
     * 默认密码123456
     */
    String DEFAULT_LOGIN_PWD = "123456";
    /**
     * 图片上传的地址
     */
    String IMAGE_UPLOAD_PATH = "F:/project/hotel/upload/";

    /**
     * 前台用户登录时保存key
     */
    String FRONT_LOGIN_USER = "currentUser";
}
