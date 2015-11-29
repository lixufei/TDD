package org.xfli.tdd;

public class Dollar extends Currency{

    public Dollar (double amount) {
        this.amount = amount;
    }

    public Currency rate(double rate) {
        return new Dollar(amount * rate);
    }

}
