package org.xfli.tdd;

public abstract class Money {
    protected double amount;
    protected String currency;

    public Money() {}
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return this.amount == money.amount && this.getClass() == money.getClass();
    }

    public static Dollar dollar(double amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(double amount) {
        return new Franc(amount, "CHF");
    }

    public abstract Money rate(double rate) ;

}
