package com.itheima.service;

import com.itheima.entity.Result;
import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 * @date 2019/11/13 10:28
 */
public interface OrderSettingService {
    /**
     * add
     * @param list
     */
    public void add(List<OrderSetting> list);

    /**
     * getOrderSettingByMonth
     * @param date
     * @return
     */
    public List<Map> getOrderSettingByMonth(String date);

    /**
     * editNumberByDate
     * @param orderSetting
     */
    public void editNumberByDate(OrderSetting orderSetting);
}
