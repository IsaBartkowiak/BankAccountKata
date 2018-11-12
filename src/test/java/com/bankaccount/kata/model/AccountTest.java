package com.bankaccount.kata.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    @Test
    public void should_create_an_account() throws Exception{
        Account account = new Account(1, "Isa account", 3000);
        assertThat(account).isInstanceOf(Account.class);
    }

    @Test
    public void should_have_an_history_initialized() throws Exception{
        Account account = new Account(1, "Isa account", 3000);
        assertThat(account.getHistory()).isInstanceOf(List.class);
    }

}
