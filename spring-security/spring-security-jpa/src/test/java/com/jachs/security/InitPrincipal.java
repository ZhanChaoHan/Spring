package com.jachs.security;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import com.jachs.security.dao.custom.PrincipalRepository;
import com.jachs.security.entity.RoleUser;
import com.jachs.security.entity.SecurityUser;
import com.jachs.security.entity.custom.Principal;

/**
 * @author zhanchaohan
 * 初始化自定义校长数据
 */
@SpringBootTest
public class InitPrincipal {
    @Autowired
    private PrincipalRepository principalRepository;
    
    private static final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
    
    @Test
    public void addOne() {
        RoleUser ru=new RoleUser ();
        ru.setAccountNonExpired ( false );
        ru.setAccountNonLocked ( false );
        ru.setCredentialsNonExpired ( false );
        ru.setEnabled ( false );
        ru.setName ( "校长用户" );
        ru.setPassword ( encoder.encode ("123456" ) );
        ru.setPhone ( 878545L );
        ru.setUsername ( "master" );
        
        Set<SecurityUser>suSet=new HashSet<> ();
        suSet.add ( new SecurityUser ( null, ru.getId (), 1, "ROLE_Principal" ) );//设置权限
        ru.setAuthorities ( suSet );
        
        
        Principal principal=new Principal();
        
        principal.setPrincipalAge ( 10 );
        principal.setPrincipalName ( "master" );
        principal.setRoleUser ( ru );
        
        principalRepository.save ( principal );
    }
    @Test
    public void AddMany() {
    	Random rd=new Random();
    	
    	for (int kk = 2; kk < 20; kk++) {
    		  RoleUser ru=new RoleUser ();
    	        ru.setAccountNonExpired ( false );
    	        ru.setAccountNonLocked ( false );
    	        ru.setCredentialsNonExpired ( false );
    	        ru.setEnabled ( false );
    	        ru.setName ( "测试用校长"+kk );
    	        ru.setPassword ( encoder.encode ("123456" ) );
    	        ru.setPhone ( rd.nextLong() );
    	        ru.setUsername ( "master"+kk);
    	        
    	        Set<SecurityUser>suSet=new HashSet<> ();
    	        suSet.add ( new SecurityUser ( null, ru.getId (), 1, "ROLE_Principal" ) );//设置权限
    	        ru.setAuthorities ( suSet );
    	        
    	        
    	        Principal principal=new Principal();
    	        
    	        principal.setPrincipalAge ( 10+kk );
    	        principal.setPrincipalName ( "master"+kk );
    	        principal.setRoleUser ( ru );
    	        
    	        principalRepository.save ( principal );
		}
    }
    @Test//测试级联删除OK
    public void TestDeleteOne() {
        principalRepository.deleteAll ();
    }
}
