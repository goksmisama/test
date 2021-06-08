package com.youle.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youle.constant.MessageConstant;
import com.youle.entity.PageResult;
import com.youle.entity.QueryPageBean;
import com.youle.entity.Result;
import com.youle.pojo.CheckGroup;
import com.youle.pojo.CheckItem;
import com.youle.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author MaRui
 * @date 2021-05-29 10:37
 */
@RequestMapping("/checkGroup")
@RestController
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;

    @RequestMapping("/add.do")
    public Result add(@RequestBody CheckGroup CheckGroup, Integer[] checkitemIds) {
        try {
            System.out.println(checkitemIds);
            checkGroupService.add(CheckGroup, checkitemIds);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }

    @RequestMapping("/findPage.do")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = checkGroupService.pageQuery(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/findById.do")
    public Result findById(@RequestParam(required = true, name = "id") Integer checkGroupId) {
        try {
            CheckGroup checkGroup = checkGroupService.findById(checkGroupId);
            return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, checkGroup);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }

    @RequestMapping("/edit.do")
    public Result edit(@RequestBody CheckGroup CheckGroup, Integer[] checkitemIds) {
        try {
            System.out.println(checkitemIds);
            checkGroupService.edit(CheckGroup, checkitemIds);
            return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
    }

    @RequestMapping("/findCheckItemsByCheckGroupId.do")
    public Result findCheckItemsByCheckGroupId(Integer id) {
        try {
            List<Integer> list=checkGroupService.findCheckItemsByCheckGroupId(id);
            return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    @RequestMapping("/delete.do")
    public Result delete(Integer id) {
        try {
            checkGroupService.delete(id);
        }  catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }

    @RequestMapping("/findAll.do")
    public Result findAll() {
        try {
            List<CheckItem> rows = checkGroupService.findAll();
            return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, rows);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }
}
