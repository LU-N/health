package com.itheima.service;

import com.itheima.entity.Result;

import java.util.Map;

/**
 * 体检预约服务接口
 * @author JinLu
 * @date 2019/11/16 09:10
 */
public interface OrderService {
    /**
     * 体检预约
     * @param map
     * @return
     * @throws Exception
     */

    public Result order(Map map) throws Exception;

    /**
     * 根据id查询预约信息，包括体检人信息、套餐信息
     * @param id
     * @return
     * @throws Exception
     */
    public Map findById(Integer id) throws Exception;

    /**
     * 删除预约数据
     *
     * @param date2String
     */
    void delete(String date2String);
}
