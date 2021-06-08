package com.youle.dao;

import com.youle.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author MaRui
 * @date 2021-06-06 10:11
 */
public interface OrderSettingDao {
    void add(OrderSetting orderSetting);

    void edit(OrderSetting orderSetting);

    long findCountByOrderDate(Date orderDate);

    List<OrderSetting> getOrderSettingByMonth(Map map);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);
}
