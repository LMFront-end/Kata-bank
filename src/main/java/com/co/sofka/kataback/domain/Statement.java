package com.co.sofka.kataback.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statement {

    private final String title = "|Date           |Credit         |Debit          |Balance        |";
    private List<String> statement;

    public Statement(){
        statement = new ArrayList<>();
    }

    public String getTitle(){
        return title;
    }

    public List<String> getStatement(){
        return statement;
    }

    private void sortStatementByDate(){
        statement.sort((l1, l2) -> l1.substring(1, 11).compareTo(l2.substring(1, 11)));
        statement.sort(Collections.reverseOrder());
    }

    public void appendLine(String inputDate, int credit, int debit, int balance){
        statement.add(StatementLine.getStatementLine(inputDate, credit, debit, balance));
        sortStatementByDate();
    }
}
