package com.jk.dao;

import com.jk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author 10432
 * @Title: UserJpaDao
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0317:54
 */
@Transactional
public interface UserJpaDao extends JpaRepository<User,Integer>{

}
