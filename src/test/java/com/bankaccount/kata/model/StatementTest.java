package com.bankaccount.kata.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementTest {

    @Test
    public void should_be_deposit_when_amount_is_positive() {
        Statement statement = new Statement(LocalDateTime.now(), 50,100);
        assertThat(statement.getOperationType()).isEqualTo("DEPOSIT");
    }


    @Test
    public void should_be_deposit_when_amount_is_negative() {
        Statement statement = new Statement(LocalDateTime.now(), -50,100);
        assertThat(statement.getOperationType()).isEqualTo("WITHDRAWAL");

    }

    @Test
    public void should_print_right_infos() {
        LocalDateTime date = LocalDateTime.now();
        Statement statement = new Statement(date, -50,100);
        assertThat(statement.toString()).isEqualTo("WITHDRAWAL | " + date + " | -50.0 | 100.0");
    }

}
