package com.youle.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youle.constant.MessageConstant;
import com.youle.entity.Result;
import com.youle.service.ReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author MaRui
 * @date 2021-06-08 9:21
 */
@RequestMapping("/report")
@RestController
public class ReportController {
    @Reference
    private ReportService reportService;


    @RequestMapping("/getMemberReport.do")
    public Result getMenmberReport() {
      Map<String, Object> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -12);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
        List<String> months = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            calendar.add(Calendar.MONTH, 1);
            months.add(sdf.format(calendar.getTime()));
        }
        map.put("months", months);
        List<Integer> memberCount = reportService.findMemberCountByMonth(months);
        map.put("memberCount", memberCount);
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS, map);
    }
}
