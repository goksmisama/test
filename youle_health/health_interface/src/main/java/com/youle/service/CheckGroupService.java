package com.youle.service;

import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.pojo.CheckGroup;
import com.youle.pojo.CheckItem;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-29 10:43
 */
public interface CheckGroupService {

    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    PageResult pageQuery(QueryPageBean queryPageBean);

    CheckGroup findById(Integer checkGroupId);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    List<Integer> findCheckItemsByCheckGroupId(Integer id);

    void delete(Integer id);

    List<CheckItem> findAll();
}
