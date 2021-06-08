package com.youle.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.youle.dao.PermissionDao;
import com.youle.dao.RoleDao;
import com.youle.dao.UserDao;
import com.youle.pojo.Permission;
import com.youle.pojo.Role;
import com.youle.pojo.User;
import com.youle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author MaRui
 * @date 2021-06-07 15:56
 */
@Service(interfaceClass = UserService.class)
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        System.out.println(user.getUsername());
        if (user == null) {
            return null;
        }
        Integer id = user.getId();
        Set<Role> roles = roleDao.findByUserId(id);
        if(roles != null && roles.size() > 0){
            for(Role role : roles){
                Integer roleId = role.getId();
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);
                if(permissions != null && permissions.size() > 0){ role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }
        return user;
    }
}
