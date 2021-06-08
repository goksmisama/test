package com.youle.dao;

import com.github.pagehelper.Page;
import com.youle.pojo.CheckItem;
import com.youle.pojo.Setmeal;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-30 13:17
 */
public interface SetmealDao {
    void addSetmealAndChechGroup(Integer id, Integer checkgroupId);


    void add(Setmeal setmeal);

    Page<Setmeal> pageQueryByCondition(String queryString);

    List<Setmeal> findAll();

    Setmeal findById(Integer id);

}
