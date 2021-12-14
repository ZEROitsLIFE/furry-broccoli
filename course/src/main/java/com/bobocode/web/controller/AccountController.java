package com.bobocode.web.controller;

import com.bobocode.entuty.Account;
import com.bobocode.model.AccountModel;
import com.bobocode.service.AccountInformationService;
import com.bobocode.service.AccountService;
import com.bobocode.entuty.AccountInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountInformationService accountInformationService;

    @GetMapping
    public List<Account> getAll() throws SQLException {
        return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account get(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @GetMapping("/login")
    public AccountInformation login(@RequestBody AccountModel account)
    {
        Account account1 = accountService.findByUser(account.getUser_name());
        if (account.getPassword() == account1.getPassword())
            return accountInformationService.findByUser_id(account1.getUser_id());
else return null;
//        else throw new  IllegalStateException("Invalid account user name or password");
    }

    @PostMapping
    public void postUser(@RequestBody Account account) {
        accountService.save(account);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Account account) {
        if (!Objects.equals(id, account.getId())) {
            throw new IllegalStateException("Invalid account id");
        }
        accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        Account account = accountService.findById(id);
        accountService.remove(account);
    }
}
