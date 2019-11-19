package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.MemberDao;
import com.itheima.pojo.Member;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JinLu
 * @date 2019/11/16 20:40
 */
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    /**
     * 根据电话号查找
     *
     * @param telephone
     * @return
     */
    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    /**
     * 保存会员信息
     *
     * @param member
     */
    @Override
    public void add(Member member) {
        String password = member.getPassword();
        if (password != null) {
            password = MD5Utils.md5(password);
            member.setPassword(password);
        }
        memberDao.add(member);
    }

    /**
     * 根据月份查询会员数量
     *
     * @param months
     * @return
     */
    @Override
    public List<Integer> findMemberCountByMonths(List<String> months) {
        ArrayList<Integer> memberCount = new ArrayList<>();
        for (String month : months) {
            String data = month + ".31";
            Integer count = memberDao.findMemberCountBeforeDate(data);
            memberCount.add(count);
        }
        return memberCount;
    }
}
