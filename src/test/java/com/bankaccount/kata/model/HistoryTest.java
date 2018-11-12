package com.bankaccount.kata.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryTest {

    private History history = new History();

    @Test
    public void should_add_one_statement_when_one_statement_is_added() throws Exception {
        this.history.addStatement(100,100);
        System.out.println(this.history.getStatements());
        assertThat(this.history.getStatements().size()).isEqualTo(1);
    }

}
