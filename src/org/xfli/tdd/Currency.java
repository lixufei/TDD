package org.xfli.tdd;

public abstract class Currency {
    protected double amount;

    public Currency () {}

    public boolean equals(Object object) {
        Currency currency = (Currency)object;
        return this.amount == currency.amount && this.getClass() == currency.getClass();
    }

    public static Dollar dollar(double amount) {
        return new Dollar(amount);
    }

    public static Franc franc(double amount) {
        return new Franc(amount);
    }

    public abstract Currency rate(double rate) ;

}
