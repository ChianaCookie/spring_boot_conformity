package com.jk.service;

import com.jk.pojo.User;

import java.util.List;

/**
 * @author 10432
 * @Title: UserService
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0317:53
 */
public interface UserService {
    List<User> jpaQueryUser();
}
