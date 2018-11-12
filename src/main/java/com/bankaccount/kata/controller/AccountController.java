package com.bankaccount.kata.controller;
import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bankaccount.kata.service.AccountService;
import java.util.List;


@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService service){
        this.accountService = service;
    }

    @RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
    public String index() {
        return "Bank account KATA API";
    }

    @RequestMapping(value="/accounts", method=RequestMethod.GET, produces="application/json")
    public List<Account> getAccounts() {
        return this.accountService.getAccounts();
    }

    @RequestMapping(value="/accounts/{id}/deposit", method=RequestMethod.PUT, consumes = "application/json",  produces = "application/json")
    public Account deposit(@PathVariable(value="id") Long id, @RequestBody Amount amount) throws Exception{
        Account a = this.accountService.depositOnAccount(id, amount.getAmount());
        return a;
    }

    @RequestMapping(value="/accounts/{id}/withdrawal", method=RequestMethod.PUT, consumes = "application/json",  produces = "application/json")
    public Account withdrawal(@PathVariable(value="id") Long id, @RequestBody Amount amount) throws Exception {
        Account a = this.accountService.withdrawalOnAccount(id, amount.getAmount());
        return a;
    }
}
