package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 */
public interface CheckGroupDao {
    /**
     * 添加
     * @param checkGroup
     */
    public void add(CheckGroup checkGroup);

    /**
     * setCheckGroupAndCheckItem
     * @param map
     */
    public void setCheckGroupAndCheckItem(Map map);

    /**
     * findByCondition
     * @param queryString
     * @return
     */
    public Page<CheckGroup> findByCondition(String queryString);

    /**
     * findById
     * @param id
     * @return
     */
    public CheckGroup findById(Integer id);

    /**
     * findCheckItemIdsByCheckGroupId
     * @param id
     * @return
     */
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 编辑
     * @param checkGroup
     */
    public void edit(CheckGroup checkGroup);

    /**
     * 删除关联
     * @param id
     */
    public void deleteAssocication(Integer id);

    /**
     * findAll
     * @return
     */
    public List<CheckGroup> findAll();
}
