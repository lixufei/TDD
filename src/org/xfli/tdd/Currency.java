package org.xfli.tdd;

public class Currency {
    protected double amount;

    public Currency () {}

    public boolean equals(Object object) {
        return this.amount == ((Currency)object).amount;
    }
}
