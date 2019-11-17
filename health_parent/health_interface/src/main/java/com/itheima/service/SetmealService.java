package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Setmeal;

import java.util.List;

/**
 * @author JinLu
 * @date 2019/11/12 14:49
 */
public interface SetmealService {
    /**
     * 添加
     *
     * @param setmeal
     * @param checkgroupIds
     */
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 获取套餐数据
     * @return
     */
    public List<Setmeal> findAll();

    /**
     * 查询id展示套餐信息
     * @param id
     * @return
     */
    public Setmeal findById(int id);
}
