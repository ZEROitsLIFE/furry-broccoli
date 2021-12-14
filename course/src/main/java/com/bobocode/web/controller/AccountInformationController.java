package com.bobocode.web.controller;

import com.bobocode.service.AccountInformationService;
import com.bobocode.entuty.AccountInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/account-info")
public class AccountInformationController {
    @Autowired
    private AccountInformationService accountInformationService;

    @GetMapping
    public List<AccountInformation> getAll() {
        return accountInformationService.findAll();
    }

    @GetMapping(value = "/{id}")
    public AccountInformation get(@PathVariable Long id) {
        return accountInformationService.findByUser_id(id);
    }

    @PostMapping
    public void postUser(@RequestBody AccountInformation account) {
        accountInformationService.save(account);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody AccountInformation account) {
        if (!Objects.equals(id, account.getUser_id())) {
            throw new IllegalStateException("Invalid account id");
        }
        accountInformationService.save(account);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        AccountInformation account = accountInformationService.findByUser_id(id);
        accountInformationService.remove(account);
    }
}
