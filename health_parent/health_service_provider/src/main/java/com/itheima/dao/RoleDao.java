package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.Set;

/**
 * @author JinLu
 */
public interface RoleDao {
    /**
     * 根据用户id查询关联角色
     *
     * @param userId
     * @return
     */
    public Set<Role> findByUserId(Integer userId);
}
