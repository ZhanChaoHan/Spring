package com.jachs.springel.entity;

public class Email {

    private String email;
    private Circle circle;

    public Email(String email) {
        this.email = email;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", circle=" + circle +
                '}';
    }

}