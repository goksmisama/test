package com.youle.dao;

import com.github.pagehelper.Page;
import com.youle.pojo.CheckItem;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-28 15:58
 */
public interface CheckItemDao {
    void add(CheckItem checkItem);

    Page<CheckItem> pageQueryByCondition(String queryString);

    void delete(Integer id);

    long findCountById(Integer id);

    CheckItem findById(Integer id);

    void update(CheckItem checkItem);

    List<CheckItem> findAll() ;
    List<CheckItem> findByCheckGroupId(Integer checkGroupId) ;


}

