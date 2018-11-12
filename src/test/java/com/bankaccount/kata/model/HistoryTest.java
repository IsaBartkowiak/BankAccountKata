package com.bankaccount.kata.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryTest {

    History history;LocalDateTime date;

    @BeforeEach
    public void initializeMockHistory() {
        this.history = new History();
        this.date = LocalDateTime.now();
        this.history.addLine(50,50);
    }

    @Test
    public void should_add_one_statement_when_one_statement_is_added() {
        this.history.addLine(50,50);
        assertThat(this.history.getStatements().size()).isEqualTo(2);
    }

    @Test
    public void should_have_a_deposit_statement_when_deposit_of_50_is_added() {
        assertThat(this.history.toString()).isEqualTo("DEPOSIT | "+this.date+ " | "+ 50+" | "+50);
    }

}
