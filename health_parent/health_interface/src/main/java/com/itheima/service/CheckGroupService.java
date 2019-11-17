package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

/**
 * @author JinLu
 */
public interface CheckGroupService {
    /**
     * 添加
     * @param checkGroup
     * @param checkitemIds
     */
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 显示数据
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 查找
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
     * 编辑数据
     * @param checkGroup
     * @param checkitemIds
     */
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     *
     * @return
     */
    public List<CheckGroup> findAll();
}
