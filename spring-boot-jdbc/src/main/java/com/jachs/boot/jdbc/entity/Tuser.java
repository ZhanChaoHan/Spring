package com.jachs.boot.jdbc.entity;

import java.util.Date;

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
public class Tuser {
    private int id;
    private String user_name;
    private String password;
    private Date last_login_time;
    private int sex;
    
}
