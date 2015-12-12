package org.xfli.tdd;

public class Money implements Expression{
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

    public static Money dollar(double amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(double amount) {
        return new Money(amount, "CHF");
    }

    public Money rate(double rate) {
        return new Money(amount * rate, currency) ;
    }

    Expression plus(Money dollar) {
        return new Sum(this, dollar);
    }

    public Money reduce (Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
