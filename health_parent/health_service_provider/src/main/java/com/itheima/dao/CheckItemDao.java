package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;


/**
 * 持久层dao接口
 *
 * @author JinLu
 * @date 2019/11/9 15:42
 */
public interface CheckItemDao {
    /**
     * add
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * selectByCondition
     * @param queryString
     * @return
     */
    public Page<CheckItem> selectByCondition(String queryString);

    /**
     * deleteById
     * @param id
     */
    public void deleteById(Integer id);

    /**
     *  根据检查项id查询
     * @param checkItemId
     * @return
     */
    public long findCountByCheckItemId(Integer checkItemId);

    /**
     * edit
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

    /**
     * findById
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);

    /**
     * findAll
     * @return
     */
    public List<CheckItem> findAll();
}
