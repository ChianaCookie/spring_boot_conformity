package com.jk.service.impl;

import com.jk.dao.UserJpaDao;
import com.jk.pojo.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10432
 * @Title: UserServiceImpl
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0317:53
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaDao userJpaDao;


    @Override
    public List<User> jpaQueryUser() {
        List<User> list = userJpaDao.findAll();
        return list;
    }
}
