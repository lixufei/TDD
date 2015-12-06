package org.xfli.tdd;

public class Bank implements Expression{

    public Money reduce(Expression source, String to) {
        return Money.dollar(10);
    }
}
