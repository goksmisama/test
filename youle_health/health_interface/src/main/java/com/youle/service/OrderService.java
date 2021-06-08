package com.youle.service;

import com.youle.entity.Result;

import java.util.Map;

/**
 * @author MaRui
 * @date 2021-06-07 11:02
 */
public interface OrderService {

    Result order(Map map) throws Exception;

    Map findById(Integer id) throws Exception;
}
