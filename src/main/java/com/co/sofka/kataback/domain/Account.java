package com.co.sofka.kataback.domain;

public class Account {

    private Statement statement;
    private int balance = 0;

    public Account(Statement statement){
        this.statement = statement;
    }

    public void deposit(int credit, String date){
        balance += credit;
        this.statement.appendLine(date, credit, 0, balance);
    }

    public void withdrawal(int debit, String date){
        balance -= debit;
        this.statement.appendLine(date, 0, debit, balance);
    }

    public void printStatement(){
        System.out.println("-".repeat(65));
        System.out.println(statement.getTitle());
        statement.getStatement().forEach(System.out::println);
        System.out.println("-".repeat(65));
    }
}
