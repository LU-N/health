package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 *
 * @author JinLu
 */
public interface CheckItemService {
    /**
     * add
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * pageQuery
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 根据id删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * 编辑
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);

    /**
     * 检查项信息
     * @return
     */
    public List<CheckItem> findAll();
}
