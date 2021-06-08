package com.youle.service;

import com.youle.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * @author MaRui
 * @date 2021-06-06 10:05
 */
public interface OrderSettingService {

    void add(List<OrderSetting> orderSettingList);

    List<Map> getOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);
}
