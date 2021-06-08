package com.youle.dao;

import com.youle.pojo.Role;

import java.util.Set;

/**
 * @author MaRui
 * @date 2021-06-07 16:06
 */
public interface RoleDao {
    public Set<Role> findByUserId(Integer userId);
}
