package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.Set;

/**
 * @author JinLu
 */
public interface PermissionDao {
    /**
     * 根据觉得ID查询关联权限
     *
     * @param roleId
     * @return
     */
    public Set<Permission> findByRoleId(Integer roleId);
}
