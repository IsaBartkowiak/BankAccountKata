package com.bankaccount.kata.model;

import com.bankaccount.kata.dao.AccountRepository;
import com.bankaccount.kata.dao.AccountRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountRepositoryTest {

    /*
    public Account createAccount(long id, String name, double balance);
    public Account depositOnAccount(long accountId, double amount);
    public Account withdrawalOnAccount(long accountId, double amount);
    public List<Statement> getHistory(long accountId);

    */

    AccountRepositoryMemory repo;

    @BeforeEach
    public void initializeMockRepo() {
        this.repo = new AccountRepositoryMemory();
    }

    @Test
    public void should_can_create_an_account() throws Exception{
        Account a = this.repo.createAccount((long) 3, "Isa account", 1000);
        assertThat(a).isInstanceOf(Account.class);
    }


    @Test
    public void should_can_deposit_100_on_account_1() throws Exception{
        Account a = this.repo.depositOnAccount((long) 1, 1000);
        assertThat(a.getBalance()).isEqualTo(6000);
    }

    @Test
    public void should_can_withdrawal_100_on_account_1() throws Exception{
        Account a = this.repo.withdrawalOnAccount((long) 1, 500);
        assertThat(a.getBalance()).isEqualTo(500);
    }

    @Test
    public void should_can_get_all_operations_history() throws Exception{
        List<Statement> a = this.repo.getHistory((long) 1);
        assertThat(a).isIntanceOf(List.class);
    }

}
