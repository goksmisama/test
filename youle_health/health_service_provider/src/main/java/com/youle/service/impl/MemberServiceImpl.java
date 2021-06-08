package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.youle.dao.MemberDao;
import com.youle.pojo.Member;
import com.youle.service.MemberService;
import com.youle.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MaRui
 * @date 2021-06-07 14:56
 */
@Service(interfaceClass = MemberService.class)
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public void add(Member member) {
        if (member.getPassword() != null) {
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public Member findByTelephone(String telephone) {
        System.out.println(memberDao.findByTelephone(telephone));
        return memberDao.findByTelephone(telephone);
    }
}
