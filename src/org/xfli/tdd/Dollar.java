package org.xfli.tdd;

public class Dollar extends Currency{

    public Dollar (double amount) {
        this.amount = amount;
    }

    Dollar rate(double usd) {
        return new Dollar(amount * usd);
    }
}
