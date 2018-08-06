package com.jk.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 10432
 * @Title: User
 * @ProjectName spring_boot_conformity
 * @Description: TODO
 * @date 2018-08-0317:46
 */
@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer userid;
    private String  text;
    private String  pid;
    private String  password;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date    createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
