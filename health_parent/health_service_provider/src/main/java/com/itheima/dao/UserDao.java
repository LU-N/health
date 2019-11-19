package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @author JinLu
 */
public interface UserDao {
    /**
     * findByUsername
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
