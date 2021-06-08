/*
package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.youle.constant.RedisConstant;
import com.youle.dao.SetmealDao;
import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.pojo.Setmeal;
import com.youle.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.List;

*/
/**
 * @author MaRui
 * @date 2021-05-30 13:13
 *//*

@Service(interfaceClass = SetmealService.class)
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class SetmealServiceImpl_bak implements SetmealService {
    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private SetmealDao setmealDao;
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        for (Integer checkgroupId : checkgroupIds) {
            setmealDao.addSetmealAndChechGroup(setmeal.getId(), checkgroupId);
        }
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());
    }

    @Override
    public PageResult pagxeQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> page = setmealDao.pageQueryByCondition(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Setmeal> findAll() {
        List<Setmeal> list = setmealDao.findAll();
        return list;
    }

    @Override
    public Setmeal findById(Integer id) {
        Setmeal setmeal = setmealDao.findById(id);
        return setmeal;
    }
}
*/
