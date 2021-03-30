package com.jachs.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.security.entity.RoleUser;
/*
 * 登录用Dao
 * @author zhanchaohan
 *
 */
@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{
    RoleUser findByusername ( String Username );
}
