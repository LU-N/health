package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 服务接口
 * @author JinLu
 */
public interface CheckItemService {
    /**
     * 添加
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 根据id查询
     *
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 编辑
     *
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);

    /**
     * findAll
     *
     * @return
     */
    public List<CheckItem> findAll();
}
