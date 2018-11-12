package com.bankaccount.kata.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatementTest {

    @Test
    public void should_be_deposit_when_amount_is_positive() throws Exception{
        Statement statement = new Statement(LocalDateTime.now(), 50,100);
        assertThat(statement.getOperationType()).isEqualTo("DEPOSIT");
    }


    @Test
    public void should_be_deposit_when_amount_is_negative() throws Exception{
        Statement statement = new Statement(LocalDateTime.now(), -50,100);
        assertThat(statement.getOperationType()).isEqualTo("WITHDRAWAL");

    }

    @Test
    public void should_throw_exception_when_deposit_of_0() {
        assertThrows(Exception.class, ()-> {
            LocalDateTime date = LocalDateTime.now();
            new Statement(date ,0, 0);
        });
    }

    @Test
    public void should_print_right_infos() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        Statement statement = new Statement(date, -50,100);
        assertThat(statement.toString()).isEqualTo("WITHDRAWAL | " + date + " | -50.0 | 100.0");
    }

}