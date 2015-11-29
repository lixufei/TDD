package org.xfli.tdd;

public class Franc extends Currency {

    public Franc (double amount) {
        this.amount = amount;
    }

    public Currency rate(double rate) {
        return new Franc(amount * rate);
    }

}
