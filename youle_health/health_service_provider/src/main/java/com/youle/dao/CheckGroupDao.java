package com.youle.dao;

import com.github.pagehelper.Page;
import com.youle.pojo.CheckGroup;
import com.youle.pojo.CheckItem;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-29 10:47
 */
public interface CheckGroupDao {


    void add(CheckGroup checkGroup);

    void setAssociation(Integer id, Integer checkitemId);

    Page<CheckGroup> pageQueryByCondition(String queryString);

    CheckGroup findById(Integer checkGroupId);

    void update(CheckGroup checkGroup);

    void deleteAssociation(Integer id);

    List<Integer> findCheckItemsByCheckGroupId(Integer id);

    void delete(Integer id);

    List<CheckItem> findAll();

    List<CheckGroup> findCheckGroupBySetmealId(Integer SetmealId);
}


