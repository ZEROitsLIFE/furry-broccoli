package com.bobocode.entuty;

import javax.persistence.Column;
import javax.persistence.MapKey;
import javax.xml.crypto.Data;

public class AccountInformation {

    @MapKey
    @Column(name = "user_id", unique = true)
    private Long user_id;

    @Column(name = "sex")
    private String sex;

    @Column(name = "dateofbirth")
    private Data data;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "email", unique = true)
    private String email;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AccountInformation{" +
                "user_name='" + user_id + '\'' +
                ", sex='" + sex + '\'' +
                ", data=" + data +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
