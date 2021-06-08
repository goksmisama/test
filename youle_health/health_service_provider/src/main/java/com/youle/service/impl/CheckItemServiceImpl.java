package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youle.dao.CheckItemDao;
import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.pojo.CheckItem;
import com.youle.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youle
 * @date 2021-05-28 15:46
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.pageQueryByCondition(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void delete(Integer id) throws RuntimeException {
        long count = checkItemDao.findCountById(id);
        if (count > 0) {
            throw new RuntimeException("当前检查项被引用，不能删除");
        } else {
            checkItemDao.delete(id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public CheckItem findById(Integer id) {
        CheckItem checkItem = checkItemDao.findById(id);
        return checkItem;
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

    @Override
    public void deleteSelect(ArrayList<CheckItem> list) {
        long count = 0;
        for (CheckItem checkItem : list) {
            Integer id = checkItem.getId();
            count+= checkItemDao.findCountById(id);
        }
        if (count > 0) {
            throw new RuntimeException("当前选中的检查项中有检查项被引用，不能删除");
        } else {
            for (CheckItem checkItem : list) {
                Integer id = checkItem.getId();
                checkItemDao.delete(id);
            }
        }

    }

    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> rows=checkItemDao.findAll();
        return rows;
    }
}
