package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 * @date 2019/11/12 15:11
 */
public interface SetmealDao {
    /**
     * add
     * @param setmeal
     */
    public void add(Setmeal setmeal);

    /**
     * setSetmealAndCheckGroup
     * @param map
     */
    public void setSetmealAndCheckGroup(Map map);

    /**
     * 查找
     * @param queryString
     * @return
     */
    public Page<Setmeal> findByCondition(String queryString);

    /**
     * 查询套餐信息
     * @return
     */
    public List<Setmeal> findAll();

    /**
     * 展示套餐信息(id)
     * @param id
     * @return
     */
    public Setmeal findById(int id);
}
