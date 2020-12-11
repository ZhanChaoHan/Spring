package com.jachs.security.entity.custom;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jachs.security.entity.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanchaohan
 * 自定义测试用校长实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Principal")
public class Principal {
    @Id
    @Column(name = "PrincipalName")
    private String PrincipalName;
    
    @Column(name = "PrincipalAge")
    private Integer PrincipalAge;
    
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity =RoleUser.class  )
    @JoinColumn(name="UserId")
    private RoleUser RoleUser;
}
