package com.jachs.boot.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jachs.boot.jdbc.entity.Tuser;

/**
 * @author zhanchaohan
 */
@Repository
public class TuserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public void save(Tuser user) {
        String sql = "insert into t_user(id,user_name,password,last_login_time,sex) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getId (),user.getUser_name (),user.getPassword (),user.getLast_login_time (),user.getSex ());
    }
}
