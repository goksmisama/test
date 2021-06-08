package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youle.constant.MessageConstant;
import com.youle.dao.CheckGroupDao;
import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.entity.Result;
import com.youle.pojo.CheckGroup;
import com.youle.pojo.CheckItem;
import com.youle.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author MaRui
 * @date 2021-05-29 10:43
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;


    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.add(checkGroup);
        for (Integer checkitemId : checkitemIds) {
            checkGroupDao.setAssociation(checkGroup.getId(), checkitemId);
        }
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage, pageSize);
        Page<CheckGroup> page = checkGroupDao.pageQueryByCondition(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public CheckGroup findById(Integer checkGroupId) {
        CheckGroup checkGroup = checkGroupDao.findById(checkGroupId);
        return checkGroup;
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.update(checkGroup);
        checkGroupDao.deleteAssociation(checkGroup.getId());
        for (Integer checkitemId : checkitemIds) {
            checkGroupDao.setAssociation(checkGroup.getId(),checkitemId);
        }
    }

    @Override
    public List<Integer> findCheckItemsByCheckGroupId(Integer id) {
        List<Integer> list = checkGroupDao.findCheckItemsByCheckGroupId(id);
        return list;
    }

    @Override
    public void delete(Integer id) {
        checkGroupDao.deleteAssociation(id);
        checkGroupDao.delete(id);
    }

    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> list = checkGroupDao.findAll();
        return list;
    }


}
