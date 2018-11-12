package com.bankaccount.kata.service;


import com.bankaccount.kata.AccountCreationRefusedException;
import com.bankaccount.kata.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void should_account_creation_be_authorized_when_initial_amount_is_above_1000_euros() throws AccountCreationRefusedException {
        Account accountToCreate = new Account(-1, "My account", 1000);

        Account createdAccount = accountService.createNewAccount(accountToCreate);

        assertThat(createdAccount).isNotNull();
    }

    @Test(expected = AccountCreationRefusedException.class)
    public void should_account_creation_be_refused_when_initial_amount_is_below_1000_euros() throws AccountCreationRefusedException {
        Account accountToCreate = new Account(-1, "My account", 900);

        accountService.createNewAccount(accountToCreate);
    }
}
