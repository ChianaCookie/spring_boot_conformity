package com.jk.dao;

import com.jk.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10432
 * @Title: MongoDbRepo
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0323:38
 */
@Repository
public interface MongoDbRepo extends MongoRepository<User,Object> {
}
