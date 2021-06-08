package com.youle.service;

import com.youle.pojo.Member;

/**
 * @author MaRui
 * @date 2021-06-07 14:49
 */
public interface MemberService {
    public void add(Member member);
    public Member findByTelephone(String telephone);
}
