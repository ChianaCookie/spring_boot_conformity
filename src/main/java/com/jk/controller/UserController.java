package com.jk.controller;

import com.jk.dao.MongoDbRepo;
import com.jk.dao.UserJdbc;
import com.jk.pojo.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author 10432
 * @Title: UserController
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0317:52
 */
@Controller
@RequestMapping("demo")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserJdbc userJdbc;
    @Autowired
    private MongoDbRepo mongoDbRepo;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("jpaQueryUser")
    @ResponseBody
    public List<User> jpaQueryUser(){
        List<User> userlist=userService.jpaQueryUser();
        System.out.println("jpa");
        return userlist;
    }

    @Cacheable(value="thisredis", key="'jdbcQueryUser'")
    @RequestMapping("jdbcQueryUser")
    @ResponseBody
    public List<User> jdbcQueryUser(){
        List<User> userlist=userJdbc.getUserList();
        System.out.println("jdbc");
        return userlist;
    }
    @RequestMapping("jdbcQueryUserById")
    @ResponseBody
    public List<User> jdbcQueryUserById(){
        List<User> userlist=userJdbc. getUserListById(3);
        System.out.println("jdbc");
        return userlist;
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public int insertUser(){
        User user=new User();
        user.setUserid(13);
        user.setPid("1");
        user.setText("刘庆");
        user.setPassword("123");
        user.setCreatetime(new Date());
        redisTemplate.opsForSet().add("user",user);
        mongoDbRepo.save(user);
        return userJdbc.insertUser(user);
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public int deleteUser(){
        Integer id=10;
        return userJdbc.deleteUser(id);
    }
   /* @RequestMapping("deleteUserById")
    @ResponseBody
    public int deleteUserById(){
        final String[] id = new String[]{"6","7","8"};
        return userJdbc.deleteUserById(id);
    }*/
   @RequestMapping("updateUser")
   @ResponseBody
   public int updateUser(){
       Integer id=2;
       String name="南宫皓月";
       return userJdbc.updateUser(name,id);
   }


}
