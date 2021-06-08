package com.youle.service;

import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.pojo.CheckItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-28 15:42
 */
public interface CheckItemService {

    void add(CheckItem checkItem);

    PageResult pageQuery(QueryPageBean queryPageBean);

    void delete(Integer id) throws RuntimeException;

    CheckItem findById(Integer id);

    void edit(CheckItem checkItem);

    void deleteSelect(ArrayList<CheckItem> list);

    List<CheckItem> findAll();
}
