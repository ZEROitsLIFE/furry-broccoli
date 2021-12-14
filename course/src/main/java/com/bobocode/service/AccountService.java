package com.bobocode.service;


import com.bobocode.entuty.Account;
import com.bobocode.exception.EntityNotFoundException;
import com.bobocode.dao.AccountDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    private Map<Long, Account> accountMap = new HashMap<>();

    private AccountDAO accountDAO;

    public List<Account> findAll() throws SQLException {
        return new ArrayList<Account>(accountDAO.show());
    }

    public void save(Account account) {
        if (account.getId() == null) {
            long id = accountMap.size() + 1;
            account.setId(id);
            accountMap.put(id, account);
        } else {
            accountMap.put(account.getId(), account);
        }
    }

//    public void save(Long id, AccountModel account){
//
//    }

    public Account findById(Long id) {
        Account account = accountMap.get(id);
        if (account == null) {
            throw new EntityNotFoundException("Account not found by id=" + id);
        } else {
            return account;
        }
    }


    public Account findByUser(String user) {
        Account account = accountMap.get(user);
        if (account == null) {
            throw new EntityNotFoundException("Account not found by id=" + user);
        } else {
            return account;
        }
    }


    public void remove(Account account) {
        if (account.getId() != null) {
            accountMap.remove(account.getId());
        }
    }


}
