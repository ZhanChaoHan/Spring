package com.jachs.security;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import com.jachs.security.dao.custom.PrincipalRepository;
import com.jachs.security.dao.custom.TeacherRepository;
import com.jachs.security.entity.RoleUser;
import com.jachs.security.entity.SecurityUser;
import com.jachs.security.entity.custom.Principal;
import com.jachs.security.entity.custom.Teacher;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class InitTeacher {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private PrincipalRepository principalRepository;
    private static final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
    
    @Test
    public void addMany() {
        Principal principal=principalRepository.findAll ().get ( 0 );
        Random rd= new Random ();
        
        for ( int kk = 3 ; kk < 10 ; kk++ ) {
            RoleUser ru=new RoleUser ();
            ru.setAccountNonExpired ( false );
            ru.setAccountNonLocked ( false );
            ru.setCredentialsNonExpired ( false );
            ru.setEnabled ( false );
            ru.setName ( "老师用户"+kk );
            ru.setPassword (encoder.encode ("123456" ) );
            ru.setPhone ( 878545L );
            ru.setUsername ( "techar"+kk );
            
            Set<SecurityUser>suSet=new HashSet<> ();
            suSet.add ( new SecurityUser ( null, ru.getId (), 1, "ROLE_Teacher" ) );//设置权限
            ru.setAuthorities ( suSet );
            
            Teacher te=new Teacher();
            
            te.setTeacherName ( "老师01"+kk );
            te.setTeacherAge ( rd.nextInt ( 100 ) );
            te.setSalary (rd.nextDouble ());
            te.setPrincipal ( principal );
            te.setRoleUser ( ru );
            
            teacherRepository.save ( te );
        }
        
        
    }
}
