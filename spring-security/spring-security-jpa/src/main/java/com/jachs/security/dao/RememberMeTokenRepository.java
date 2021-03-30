package com.jachs.security.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.stereotype.Repository;

import com.jachs.security.entity.RememberMeToken;



/**
 * @author zhanchaohan
 * @see JdbcTokenRepositoryImpl
 * @see InMemoryTokenRepositoryImpl
 * 将登陆后用户权限码存库
 */
@Repository
public interface RememberMeTokenRepository extends JpaRepository<RememberMeToken,String>{
    RememberMeToken findBySeries ( String seriesId );


}
