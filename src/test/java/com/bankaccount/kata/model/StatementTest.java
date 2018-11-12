package com.bankaccount.kata.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

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
        System.out.println(statement.toString());
        assertThat(statement.toString()).isEqualTo("WITHDRAWAL | " + date + " | -50.0 | 100.0");
    }

}
