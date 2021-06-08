package com.youle.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youle.pojo.Permission;
import com.youle.pojo.Role;
import com.youle.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author MaRui
 * @date 2021-06-07 15:43
 */
@Component("springSecurityUserService")
public class SpringSecurityUserService implements UserDetailsService {
    @Reference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=====================");
        System.out.println(username);
        com.youle.pojo.User userInfo = userService.findByUsername(username);
        System.out.println(userInfo==null);
        if (userInfo == null) {
            return null;
        }
        List<GrantedAuthority> list = new ArrayList<>();
        Set<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                //授权
                list.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        UserDetails userDetails = new User(username, userInfo.getPassword(), list);
        return userDetails;
    }
}
