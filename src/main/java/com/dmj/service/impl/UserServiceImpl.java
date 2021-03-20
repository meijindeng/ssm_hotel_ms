package com.dmj.service.impl;

import com.dmj.dao.UserMapper;
import com.dmj.entity.User;
import com.dmj.service.UserService;
import com.dmj.utils.PasswordUtil;
import com.dmj.utils.SystemConstant;
import com.dmj.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        //自动生成盐值
        user.setSalt(UUIDUtils.randomUUID());//shiro安全验证框架
        //密码加密
        user.setPassword(PasswordUtil.md5(user.getPassword(),user.getSalt(), SystemConstant.PASSWORD_COUNT));
        return userMapper.addUser(user);
    }

    public User findUserByName(String loginName) {
        return userMapper.findUserByName(loginName);
    }

    //用户登录
    public User login(String loginName, String password) {
        //调用查询用户信息的方法
        User loginUser = userMapper.findUserByName(loginName);
        //判断对象是否为空
        if(loginUser!=null){
            //密码加密
            String newPassword = PasswordUtil.md5(password, loginUser.getSalt(),SystemConstant.PASSWORD_COUNT);
            //比较密码是否相等
            if(loginUser.getPassword().equals(newPassword)){
                return loginUser;
            }
        }
        return null;
    }
}
