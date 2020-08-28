/*
 * 创建人: zhanchaohan
 */
package com.jachs.springel.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component( "role2" )
public class Role2 {
    //赋值long型
    @Value( "#{2}" )
    private Long id;
    //字符串赋值
    @Value( "#{'role_name_2'}" )
    private String roleName;
    //字符串赋值
    @Value( "#{'note_2'}" )
    private String note;
}