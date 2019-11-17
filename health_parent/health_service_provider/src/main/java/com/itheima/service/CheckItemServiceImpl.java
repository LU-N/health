package com.itheima.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 检查服务项
 *
 * @author JinLu
 * @date 2019/11/9 15:12
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    /**
     * 注入到dao对象
     */
    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增
     *
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 检查项分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        //获取查询条件

        //当前页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //当前页面显示条数
        Integer pageSize = queryPageBean.getPageSize();
        //当前查询条件
        String queryString = queryPageBean.getQueryString();

        //使用mybatis的分页插件助手显示信息
        PageHelper.startPage(currentPage, pageSize);
        //调用dao进行条件查询
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        //总页数
        long total = page.getTotal();
        //获取当前页数据
        List<CheckItem> rows = page.getResult();

        return new PageResult(total, rows);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) throws RuntimeException {
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count > 0) {
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }
        checkItemDao.deleteById(id);
    }

    /**
     * 编辑
     * @param checkItem
     */
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    /**
     * 检查项信息
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
