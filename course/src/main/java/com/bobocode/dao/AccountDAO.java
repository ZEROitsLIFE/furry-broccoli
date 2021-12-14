package com.bobocode.dao;

import com.bobocode.entuty.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DaoTemplate<Account> {

    private DB_connection connection;

    private Statement statement;

    @Override
    public List<Account> show() throws SQLException {

        List<Account> accounts = new ArrayList<>();
        try {
            statement = connection.getConnection().createStatement();
            String SQL = "Select * from account";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Account account = new Account();

                account.setId(Long.valueOf(resultSet.getInt("id")));
                account.setUser_name(resultSet.getString("user_name"));
                account.setUser_name(resultSet.getString("password"));
                account.setUser_id(Long.valueOf(resultSet.getInt("user_id")));

                accounts.add(account);
                System.out.println("!");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}

