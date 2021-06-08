package com.youle.dao;

import com.youle.pojo.User;

/**
 * @author MaRui
 * @date 2021-06-07 15:59
 */
public interface UserDao {

    User findByUsername(String username);

}
