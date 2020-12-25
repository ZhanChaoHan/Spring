package com.jachs.boot.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jachs.boot.jdbc.entity.Tuser;

/**
 * @author zhanchaohan
 */
@Repository
public class TuserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public int save(Tuser user) {
        String sql = "insert into t_user(id,user_name,password,last_login_time,sex) values(?,?,?,?,?)";
       return jdbcTemplate.update(sql, user.getId (),user.getUser_name (),user.getPassword (),user.getLast_login_time (),user.getSex ());
    }
    public void saveAll(List<Tuser> user) {
        String sql = "insert into t_user(id,user_name,password,last_login_time,sex) values(?,?,?,?,?)";
        for ( Tuser tuser : user ) {
            jdbcTemplate.update(sql, tuser.getId (),tuser.getUser_name (),tuser.getPassword (),tuser.getLast_login_time (),tuser.getSex ());
        }
    }
    public int update(Tuser user) {
       String sql="update t_user set user_name=?, password=?, last_login_time=?, sex=? where id=?";
       return jdbcTemplate.update(sql, user.getUser_name (),user.getPassword (),user.getLast_login_time (),user.getSex (),user.getId ());
    }
    public int delete(Tuser user) {
        String sql="delete from t_user where id=?";
        return jdbcTemplate.update ( sql, user.getId () );
    }
    
    
    
    public int querySex(int id) {
        String sql="select sex from t_user where id=?";
        return jdbcTemplate.queryForObject ( sql, Integer.class );
    }
    public List<Tuser> queryAll() {
        String sql="select * from t_user";
        return jdbcTemplate.query ( sql, new RowMapper<Tuser>() {
            @Override
            public Tuser mapRow ( ResultSet rs , int rowNum ) throws SQLException {
                Tuser user=new Tuser();
                
                user.setId ( rs.getInt ( "id" ) );
                user.setUser_name ( rs.getString ( "user_name" ) );
                user.setPassword ( rs.getString ( "password" ) );
                user.setSex ( rs.getInt ( "sex" ) );
                user.setLast_login_time ( rs.getDate ( "last_login_time" ) );
                return user;
            }
        });
    }
}
