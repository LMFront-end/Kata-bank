package com.co.sofka.kataback.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StatementLine {

    private String lineDate;
    private String lineCredit;
    private String lineDebit;
    private String lineBalance;
    private final String whitespace = " ";


    public void setLineDate(String inputDate){
        lineDate = "|" + inputDate + whitespace.repeat(Math.max(0, 15 - inputDate.length())) + "|";
    }

    public void setLineCredit(int amount){
        String amount_of = Amounts.amountOf(amount);
        if (amount == 0){
            lineCredit = whitespace.repeat(15) + "|";
            return;
        }
        lineCredit = amount_of + whitespace.repeat(Math.max(0, 15 - amount_of.length())) + "|";
    }

    public void setLineDebit (int amount){
        String amount_of = Amounts.amountOf(amount);
        if (amount == 0){
            lineDebit = whitespace.repeat(15) + "|";
            return;
        }
        lineDebit = amount_of + whitespace.repeat(Math.max(0, 15 - amount_of.length())) + "|";
    }

    public void setLineBalance(int amount){
        String amount_of = Amounts.amountOf(amount);
        lineBalance = amount_of + whitespace.repeat(Math.max(0, 15 - amount_of.length())) + "|";
    }

    public static String getStatementLine(String inputDate, int credit, int debit, int balance){
        StatementLine statementLine = new StatementLine();
        statementLine.setLineDate(inputDate);
        statementLine.setLineCredit(credit);
        statementLine.setLineDebit(debit);
        statementLine.setLineBalance(balance);
        return statementLine.getLineDate() + statementLine.getLineCredit() +
                statementLine.getLineDebit() + statementLine.getLineBalance();
    }
}
