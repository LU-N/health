package com.itheima.service;


import com.itheima.pojo.Member;

/**
 * @author JinLu
 * @date 2019/11/16 19:52
 */
public interface MemberService {
    /**
     * 根据手机号查询会员
     * @param telephone
     * @return
     */
    public Member findByTelephone(String telephone);

    /**
     * 加入会员，将手机号存入会员表
     * @param member
     */
    public void add(Member member);
}
