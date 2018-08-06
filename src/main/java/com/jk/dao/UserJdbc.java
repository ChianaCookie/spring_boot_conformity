package com.jk.dao;

import com.jk.pojo.User;

import java.util.List;

/**
 * @author 10432
 * @Title: UserJdbc
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0320:13
 */
public interface UserJdbc {

    List<User> getUserList();
    List<User> getUserListById(Integer id);
    int        insertUser(User user);
    int        deleteUser(Integer id);
    /*int        deleteUserById(String[] id);*/
    int       updateUser(String name,Integer id);
}
