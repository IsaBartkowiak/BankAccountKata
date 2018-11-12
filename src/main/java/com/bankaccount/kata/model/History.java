package com.bankaccount.kata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History {
    private ArrayList<Statement> statements = new ArrayList<>();

    public List<Statement> getStatements(){
        return statements;
    }

    public void addStatement(double amount, double balance) {
        LocalDateTime date = LocalDateTime.now();
        Statement statement = new Statement(date, amount, balance);
        this.statements.add(statement);
    }

    @Override
    public String toString() {
        String s = "";
        for (Statement st : this.statements) {
            s += st.toString() + "\n";
        }
        return s;
    }
}
