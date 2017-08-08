package com.soft1010.commons.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jifuzhang on 17/8/8.
 */
@JSONType(ignores = {"email_address"},serialzeFeatures = {SerializerFeature.PrettyFormat})
public class User implements Serializable {

    @JSONField(name = "name",serialize = false)
    private String name;

    @JSONField(name = "age",serialize = true)
    private Integer age;

    @JSONField(name = "email_address",ordinal = 1)
    private String email;

    @JSONField(name = "email",alternateNames = "email_address")
    private String email_address;
    @JSONField(name = "date",format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @JSONField(serialzeFeatures={SerializerFeature.WriteMapNullValue})
    private String address;



    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
