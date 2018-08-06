package com.jk.dao;

import com.jk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author 10432
 * @Title: UserJdbcImpl
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0320:14
 */
@Repository
public class UserJdbcImpl implements UserJdbc{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<User> getUserList(){
        List<User> list= jdbcTemplate.query("select * from user ", new Object[]{}, new BeanPropertyRowMapper(User.class));

        return list;
    }
    @Transactional(readOnly = true)
    public List<User> getUserListById(Integer id){
        List<User> list= jdbcTemplate.query("select * from user where userid=? ", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if (list!=null && list.size()>0){
            return list;
        }else {
            return null;
        }
    }

    public int insertUser(User user){
        return jdbcTemplate.update("INSERT into user(userid,text,pid,password,createtime) " +
                "values(?,?,?,?,?)",user.getUserid(),user.getText(),user.getPid(),user.getPassword(),user.getCreatetime());
    }

    public int deleteUser(Integer id){

        return jdbcTemplate.update(" DELETE from user where userid=?",id);
    }

   /* public int deleteUserById(String[] id){

        return jdbcTemplate.update(" DELETE from user where userid in (?)",id);
    }*/

    public int updateUser(String name,Integer id){
      /*StringBuffer sql=new StringBuffer();
        sql.append(" update from user set text=? where userid=? ");*/
        String sql=" update  user set text=? where userid like ? ";
        return jdbcTemplate.update(sql,name,id);
    }


}
