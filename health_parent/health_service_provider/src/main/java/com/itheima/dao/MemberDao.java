package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Member;

import java.util.List;

/**
 * @author JinLu
 */
public interface MemberDao {
    /**
     *  查询所有
     *
     * @return
     */
    public List<Member> findAll();

    /**
     * 按条件查询
     *
     * @param queryString
     * @return
     */
    public Page<Member> selectByCondition(String queryString);

    /**
     * 添加预约
     *
     * @param member
     */
    public void add(Member member);

    /**
     * 根据id删除
     *
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Member findById(Integer id);

    /**
     * 根据电话查找
     *
     * @param telephone
     * @return
     */
    public Member findByTelephone(String telephone);

    /**
     * 编辑会员信息
     *
     * @param member
     */
    public void edit(Member member);

    /**
     * 查找日期之前的会员数
     *
     * @param date
     * @return
     */
    public Integer findMemberCountBeforeDate(String date);

    /**
     * 按日期查找会员数
     *
     * @param date
     * @return
     */
    public Integer findMemberCountByDate(String date);

    /**
     * 查找日期后的会员数
     *
     * @param date
     * @return
     */
    public Integer findMemberCountAfterDate(String date);

    /**
     * 查找会员总数
     *
     * @return
     */
    public Integer findMemberTotalCount();
}
