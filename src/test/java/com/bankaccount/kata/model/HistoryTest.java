package com.bankaccount.kata.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryTest {

    History history;

    @BeforeEach
    public void initializeMockHistory() throws Exception{
        this.history = new History();
    }

    @Test
    public void should_add_one_statement_when_one_statement_is_added() throws Exception {
        this.history.addLine(100,100);
        System.out.println(this.history.getStatements());
        assertThat(this.history.getStatements().size()).isEqualTo(1);
    }

}
