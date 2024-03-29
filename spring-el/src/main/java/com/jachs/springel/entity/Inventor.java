package com.jachs.springel.entity;

import java.util.Date;

/**
 * @author zhanchaohan
 * 
 */
public class Inventor {
    private String name;
    private Date birthday;
    private String nationality;
    
    
    public Inventor () {
        super ();
    }
    public Inventor ( String name, Date birthday, String nationality ) {
        super ();
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }
    public String getName () {
        return name;
    }
    public void setName ( String name ) {
        this.name = name;
    }
    public Date getBirthday () {
        return birthday;
    }
    public void setBirthday ( Date birthday ) {
        this.birthday = birthday;
    }
    public String getNationality () {
        return nationality;
    }
    public void setNationality ( String nationality ) {
        this.nationality = nationality;
    }
    
}
