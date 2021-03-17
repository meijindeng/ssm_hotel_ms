package com.dmj.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;

import java.util.UUID;

public class PasswordUtil {
    /**
     * 对密码加密 md5
     * @param source  要加密的明文
     * @param salt  盐
     * @param hashIterations  散列次数
     * @return
     */
    public static String md5(String source, Object salt, Integer hashIterations) {
        return new Md5Hash(source, salt, hashIterations).toString();
    }

    /**
     * 对密码加密sha1
     * @param source  要加密的明文
     * @param salt  盐
     * @param hashIterations  散列次数
     * @return
     */
    public static String sha1(String source, Object salt, Integer hashIterations) {
        return new Sha1Hash(source, salt, hashIterations).toString();
    }

    public static void main(String[] args) {
        String password = "123456";
        String salt = UUID.randomUUID().toString().replace("-","");
        System.out.println("加密盐值："+salt);
        System.out.println("加密后的密码："+ PasswordUtil.md5(password,salt,5));

    }
}
