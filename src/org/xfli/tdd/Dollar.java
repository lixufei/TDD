package org.xfli.tdd;

public class Dollar extends Money {

    public Dollar (double amount) {
        this.amount = amount;
    }
    public Dollar (double amount, String currency) {
        super(amount, currency);
    }

}
