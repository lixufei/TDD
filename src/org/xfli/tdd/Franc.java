package org.xfli.tdd;

public class Franc extends Currency {

    public Franc (double amount) {
        this.amount = amount;
    }

    Franc rate(double usd) {
        return new Franc(amount * usd);
    }

}
