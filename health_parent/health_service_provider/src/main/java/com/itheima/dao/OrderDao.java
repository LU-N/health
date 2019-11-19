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

    /**
     * 按日期查找订单计数
     *
     * @param date
     * @return
     */
    public Integer findOrderCountByDate(String date);

    /**
     * 在日期后查找订单计数
     *
     * @param date
     * @return
     */
    public Integer findOrderCountAfterDate(String date);

    /**
     * 查找访问者按日期计数
     *
     * @param date
     * @return
     */
    public Integer findVisitsCountByDate(String date);

    /**
     * 查找日期后的访问计数
     *
     * @param date
     * @return
     */
    public Integer findVisitsCountAfterDate(String date);

    /**
     * 获取热门套餐
     *
     * @return
     */
    public List<Map> findHotSetmeal();
}
