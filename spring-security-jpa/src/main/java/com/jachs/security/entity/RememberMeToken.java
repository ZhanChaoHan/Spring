package com.jachs.security.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 自定义持久化实体和
 * @author zhanchaohan
 * @see org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken
 * 和官方比改了个名字而已可以自己加字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RememberMeToken")
public class RememberMeToken {
    @Id
    @Column(name = "loginName")
    private String loginName;
    @Column(name = "series")
    private String series;
    @Column(name = "token")
    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date lastUsed;
}
