/*
 * 创建人: zhanchaohan
 */
package com.jachs.batch.entity;

public class Person {
    private String firstName;
    private String lastName;
    
    public Person () {
        super ();
    }
    public Person ( String firstName, String lastName ) {
        super ();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName () {
        return firstName;
    }
    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }
    public String getLastName () {
        return lastName;
    }
    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }
    
}
