package com.bobocode.service;

import com.bobocode.exception.EntityNotFoundException;
import com.bobocode.entuty.AccountInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountInformationService {
    private Map<Long, AccountInformation> accountMap = new HashMap<>();

    public List<AccountInformation> findAll() {
        return new ArrayList<>(accountMap.values());
    }

    public void save(AccountInformation account) {
        if (account.getUser_id() == null  ) {
            long id = accountMap.size() + 1;
            account.setUser_id(id);
            accountMap.put(id, account);
        } else {
            accountMap.put(account.getUser_id(), account);
        }
    }

//    public void save(Long id, AccountModel account){
//
//    }

    public void remove(AccountInformation account) {
        if (account.getUser_id() != null) {
            accountMap.remove(account.getUser_id());
        }

    }

    public AccountInformation findByUser_id(Long user_id) {
         AccountInformation account = accountMap.get(user_id);
        if (account == null) {
            throw new EntityNotFoundException("Account not found by id=" +user_id);
        } else {
            return account;
        }
    }

}
