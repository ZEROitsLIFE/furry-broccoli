package com.bobocode.entuty;

import javax.persistence.Column;
import javax.persistence.Id;

public class Account {

    @Id
    private Long Id;

    @Column(name = "user_name", unique = true)
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "user_id")
    private Long user_id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;

    }


    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
