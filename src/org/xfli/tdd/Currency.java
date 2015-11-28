package org.xfli.tdd;

public class Currency {
    double amount;
    public Currency (double amount) {
        this.amount = amount;
    }

    void rate(double usd) {
        amount *= usd;
    }
}
