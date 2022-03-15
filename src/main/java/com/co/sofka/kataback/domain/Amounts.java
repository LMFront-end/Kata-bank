package com.co.sofka.kataback.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Amounts {

    private Locale locale;
    private NumberFormat formatter;

    Amounts(){
        locale = new Locale("en", "US");
        formatter = NumberFormat.getCurrencyInstance(locale);
    }

    public static String amountOf(int amount){
        Amounts amounts = new Amounts();
        return amounts.formatter.format(amount);
    }
}
