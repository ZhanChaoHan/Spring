package com.jachs.security;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import com.jachs.security.dao.RoleUserRepository;
import com.jachs.security.entity.RoleUser;
import com.jachs.security.entity.SecurityUser;

/**
 * @author zhanchaohan
 * 初始化用户
 */
@SpringBootTest
public class InitUser {
    @Autowired
    private RoleUserRepository roleUserRepository;
    private static final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
    
    //创建一个超级用户
    @Test
    public void initMyUser() {
        
        RoleUser ru=new RoleUser();
        ru.setName ( "Jachs" );
        ru.setPassword ( encoder.encode ("123456" ) );
        ru.setPhone ( 123456L );
        ru.setUsername ( "zch" );
        ru.setAccountNonExpired ( false );
        ru.setAccountNonLocked ( false );
        ru.setCredentialsNonExpired ( false );
        
        Set<SecurityUser> authorities=new HashSet<> ();
        authorities.add ( new SecurityUser ( null, ru.getId (), 1, "ROLE_ADMIN" ));
        ru.setAuthorities ( authorities );
        
        roleUserRepository.save ( ru );
    }
    //测试查询
    @Test
    public void queryMyUser() {
        RoleUser ru=roleUserRepository.findByusername ( "zch" );
        System.out.println ( ru.getName () );
        for ( SecurityUser su : ru.getAuthorities () ) {
            System.out.println ( su.getAuthority () );
        }
    }
}
