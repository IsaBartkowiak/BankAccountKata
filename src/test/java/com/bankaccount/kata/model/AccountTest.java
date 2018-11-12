package com.bankaccount.kata.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    public void should_create_an_account(){
        Account account = new Account(1, "Isa account", 3000);
        assertThat(account).isInstanceOf(Account.class);
    }

    @Test
    public void should_have_an_history_initialized(){
        Account account = new Account(1, "Isa account", 3000);
        assertThat(account.getHistory()).isInstanceOf(List.class);
    }

}
