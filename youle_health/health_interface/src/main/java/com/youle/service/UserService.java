package com.youle.service;

import com.youle.pojo.User;

/**
 * @author MaRui
 * @date 2021-06-07 15:45
 */
public interface UserService {
    public User findByUsername(String username);
}
