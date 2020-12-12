package com.jachs.security.entity.custom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jachs.security.entity.RoleUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanchaohan
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Teacher")
public class Teacher {
    @Id
    @Column(name = "TeacherName",length = 32)
    private String TeacherName;
    @Column(name = "TeacherAge")
    private Integer TeacherAge;
    @Column(name = "Salary")
    private Double Salary;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PrincipalName")
    private Principal Principal;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity =RoleUser.class  )
    @JoinColumn(name="UserId")
    private RoleUser RoleUser;
}
