package com.soft1010.commons.third.gson;

import com.google.gson.annotations.JsonAdapter;

/**
 * Created by jifuzhang on 17/8/8.
 */
@JsonAdapter(UserTypeAdapter.class)
public class User {

    private String name;
    private Integer age;
    private String email;
    private String email_address;

    public User() {
    }

    public User(String name, Integer age, String email, String email_address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.email_address = email_address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
