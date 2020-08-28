/*
 * 创建人: zhanchaohan
 */
package com.jachs.springel.entity;

public class Role2 {
    private Long value;
    private String RoleName;
    private String note;
    
    public Role2 () {
        super ();
    }
    public Role2 ( Long value, String roleName, String note ) {
        super ();
        this.value = value;
        RoleName = roleName;
        this.note = note;
    }
    public Long getValue () {
        return value;
    }
    public void setValue ( Long value ) {
        this.value = value;
    }
    public String getRoleName () {
        return RoleName;
    }
    public void setRoleName ( String roleName ) {
        RoleName = roleName;
    }
    public String getNote () {
        return note;
    }
    public void setNote ( String note ) {
        this.note = note;
    }
    
}
