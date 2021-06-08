package com.youle.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.pojo.Setmeal;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-30 13:11
 */

public interface SetmealService {

    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pagxeQuery(QueryPageBean queryPageBean);

    List<Setmeal> findAll();

    Setmeal findById(Integer id);
}
