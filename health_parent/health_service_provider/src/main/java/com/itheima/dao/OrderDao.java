package com.itheima.dao;

import com.itheima.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 */
public interface OrderDao {
    /**
     * 添加预约
     * @param order
     */
    public void add(Order order);

    /**
     * 条件查询
     * @param order
     * @return
     */
    public List<Order> findByCondition(Order order);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Map findById4Detail(Integer id);
    public Integer findOrderCountByDate(String date);
    public Integer findOrderCountAfterDate(String date);
    public Integer findVisitsCountByDate(String date);
    public Integer findVisitsCountAfterDate(String date);
    public List<Map> findHotSetmeal();
}
