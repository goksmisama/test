package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.youle.dao.MemberDao;
import com.youle.service.OrderSettingService;
import com.youle.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaRui
 * @date 2021-06-08 10:03
 */
@Service(interfaceClass = ReportService.class)
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ReportServiceImpl implements ReportService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public List<Integer> findMemberCountByMonth(List<String> month) {
        List<Integer> list = new ArrayList<>();
        for(String m : month){
            m = m + ".31";//格式：2019.04.31
            Integer count = memberDao.findMemberCountBeforeDate(m);
            list.add(count);
        }
        return list;
    }
}
