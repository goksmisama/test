package com.youle.dao;

import com.youle.pojo.Permission;
import com.youle.pojo.Role;

import java.util.Set;

/**
 * @author MaRui
 * @date 2021-06-07 16:08
 */
public interface PermissionDao {
    public Set<Permission> findByRoleId(Integer roleId);
}
