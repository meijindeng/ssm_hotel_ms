package com.dmj.service;

import com.dmj.entity.User;

public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 根据用户名查询用户信息
     * @param loginName
     * @return
     */
    User findUserByName(String loginName);

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName, String password);
}
