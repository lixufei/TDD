package org.xfli.tdd;

public class Franc extends Money {

    public Franc(double amount) {
        this.amount = amount;
    }

    public Franc(double amount, String currency) {
        super(amount, currency);
    }

    public Money rate(double rate) {
        return new Franc(amount * rate);
    }

}
