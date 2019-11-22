package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.MessageConstant;
import com.itheima.constant.RedisConstant;
import com.itheima.dao.SetmealDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 体检套餐服务
 *
 * @author JinLu
 * @date 2019/11/12 15:09
 */
@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;
    @Autowired
    private JedisPool jedisPool;

    /**
     * 新增套餐信息同时添加检查组
     *
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        Integer setmealId = setmeal.getId();
        this.setSetmealAndCheckgroup(setmealId, checkgroupIds);
        //将图片名称保存在redis集合中
        String fileName = setmeal.getImg();
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, fileName);
    }

    /**
     * pageQuery
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> page = setmealDao.findByCondition(queryString);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * findAll
     *
     * @return
     */
    @Override
    public List<Setmeal> findAll() {
        //从redis中查询数据
        String setmeal = jedisPool.getResource().get("setmeal");
        //判断查询的数据是否为空
        if (setmeal == null || setmeal.length() == 0) {
            //如果为空，从数据库查询
            List<Setmeal> list = setmealDao.findAll();
            //将集合转换成json格式
            String json = JSON.toJSONString(list);
            //存入reids
            jedisPool.getResource().set("setmeal", json);
            return list;
        } else {
            //将获得的json格式的数据转换成对象(数组格式)
            List<Setmeal> list = JSON.parseArray(setmeal, Setmeal.class);
            return list;
        }
    }

    /**
     * 展示套餐信息(id)
     *
     * @param id
     * @return
     */
    @Override
    public Setmeal findById(int id) {
        String setid = jedisPool.getResource().get("setid" + id);
        if (setid == null || setid.length() == 0) {
            Setmeal byId = setmealDao.findById(id);
            String jsonString = JSON.toJSONString(byId);
            jedisPool.getResource().set("setid" + id,jsonString);
            return byId;
        } else {
            Setmeal setmeal = JSON.parseObject(setid, Setmeal.class);
            return setmeal;
        }
    }

    /**
     * 查找套餐数量
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findSetmealCount() {
        return setmealDao.findSetmealCount();
    }

    /**
     * 设置套餐和检查组多对多的关系，操作t_checkgroup_checkitem
     */
    public void setSetmealAndCheckgroup(Integer setmealId, Integer[] checkgroupIds) {
        if (checkgroupIds != null && checkgroupIds.length > 0) {
            for (Integer checkgroupId : checkgroupIds) {
                HashMap<String, Integer> map = new HashMap<>(16);
                map.put("setmealId", setmealId);
                map.put("checkgroupId", checkgroupId);
                setmealDao.setSetmealAndCheckGroup(map);
            }
        }
    }
}
