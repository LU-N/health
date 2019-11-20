package com.itheima.jobs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.OrderService;
import com.itheima.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author JinLu
 * @date 2019/11/20 08:43
 */
public class ClearOrder {
    @Reference
    private OrderService orderService;


    public void clear() {
        try {
            System.out.println("clearOrder Running .....");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date time = calendar.getTime();
            DateUtils.parseDate2String(time);
            String date2String = DateUtils.parseDate2String(calendar.getTime());
            orderService.delete(date2String);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
