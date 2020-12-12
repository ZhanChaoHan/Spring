package com.jachs.security.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 自定义用户
 * @author zhanchaohan
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="RoleUser")
public class RoleUser implements UserDetails {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "Id",length = 32)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "AccountNonExpired")
    private boolean AccountNonExpired;//指示用户的帐户是否已过期。过期帐户不能已验证 。 ture失效
    @Column(name = "AccountNonLocked")
    private boolean AccountNonLocked;//指示用户是锁定还是解锁。锁定的用户不能 已验证。true锁定
    @Column(name = "CredentialsNonExpired")
    private boolean CredentialsNonExpired;
    
    
    @OneToMany(targetEntity = SecurityUser.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="UserId")
    private Set<SecurityUser> authorities;
}
