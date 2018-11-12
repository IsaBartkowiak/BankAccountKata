package com.bankaccount.kata.model;

import com.bankaccount.kata.dao.InMemoryAccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private InMemoryAccountRepository repo;

    @Before
    public void setup() {
        Account account = new Account(1, "Isa account", 1000);
        repo.save(account);
    }

    @Test
    public void should_id_be_initialized_when_account_is_saved() {
        Account account = this.repo.save(new Account(-1, "Isa account", 1000));
        assertThat(account.getId()).isNotEqualTo(-1);
    }

    @Test
    public void should_can_deposit_100_on_account_1() throws Exception{
        Account a = this.repo.depositOnAccount((long) 1, 1000);
        assertThat(a.getBalance()).isEqualTo(2000);
    }

    @Test
    public void should_can_withdrawal_100_on_account_1() throws Exception{
        Account a = this.repo.withdrawalOnAccount((long) 1, 500);
        assertThat(a.getBalance()).isEqualTo(500);
    }

    @Test
    public void should_can_get_all_operations_history() throws Exception{
        List<Statement> a = this.repo.getHistory((long) 1);
        assertThat(a).isInstanceOf(List.class);
    }

}
