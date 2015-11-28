package org.xfli.tdd;

public class Currency {
    double amount;
    public Currency (double amount) {
        this.amount = amount;
    }

    Currency rate(double usd) {
        return new Currency(amount * usd);
    }

    public boolean equals(Object object) {
        return this.amount == ((Currency)object).amount;
    }
}
