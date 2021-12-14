package com.bobocode.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DB_connection {
    private static DB_connection db_connection = null;

    @Value("jdbc:mysql://localhost:3306/information")
    private String url;

    @Value("root")
    private String user;

    @Value("root")
    private String password;

    private DB_connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static DB_connection getInstance() {
        if (db_connection == null) {
            db_connection = new DB_connection();
        }
    return db_connection;
    }


}
