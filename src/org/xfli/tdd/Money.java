package org.xfli.tdd;

public class Money {
    protected double amount;
    protected String currency;

    public Money() {}
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return this.amount == money.amount && this.currency == money.currency;
    }

    public static Dollar dollar(double amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(double amount) {
        return new Franc(amount, "CHF");
    }

    public Money rate(double rate) {
        return new Money(amount * rate, currency) ;
    }

}
