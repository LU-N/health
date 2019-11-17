package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 * @date 2019/11/13 10:43
 */
public interface OrderSettingDao {
    /**
     * add
     * @param orderSetting
     */
    public void add(OrderSetting orderSetting);

    /**
     * 更新可预约人数
     * @param orderSetting
     */
    public void editNumberByOrderDate(OrderSetting orderSetting);

    /**
     * findCountByOrderDate
     * @param orderDate
     * @return
     */
    public long findCountByOrderDate(Date orderDate);

    /**
     * 根据日期范围查询预约设置信息
     * @param map
     * @return
     */
    public List<OrderSetting> getOrderSettingByMonth(Map map);

    /**
     * 根据预约日期查询预约设置信息
     * @param date
     * @return
     */
    OrderSetting findByOrderDate(Date date);

    /**
     * 更新已预约人数
     * @param orderSetting
     */
    void editReservationsByOrderDate(OrderSetting orderSetting);
}
