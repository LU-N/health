package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @author JinLu
 */
public interface UserService {
    /**
     * 用户服务接口
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
