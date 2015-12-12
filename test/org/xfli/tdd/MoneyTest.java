package org.xfli.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void should1USDEquals1andhalfCHF () {
        Money dollar = Money.dollar(1);
        assertThat(Money.dollar(1.5), is(dollar.rate(1.5)));
        assertThat(Money.dollar(2), is(dollar.rate(2)));

        Money franc = Money.franc(1);
        assertThat(Money.franc(1.5), is(franc.rate(1.5)));
        assertThat(Money.franc(2), is(franc.rate(2)));
    }

    @Test
    public void testEquality () {
        assertThat(true, is((Money.dollar(1)).equals(Money.dollar(1))));
        assertThat(false, is((Money.dollar(1)).equals(Money.dollar(2))));
        assertThat(false, is((Money.dollar(1)).equals(Money.franc(1))));
    }

    @Test
    public void testCurrency () {
        assertThat("USD", is(Money.dollar(0).currency));
        assertThat("CHF", is(Money.franc(0).currency));
    }

    @Test
    public void testDifferentClassEquality () {
        assertThat(true, is(new Money(10, "CHF").equals(new Money(10, "CHF"))));
    }

    @Test
    public void testSimpleAddition () {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(Money.dollar(10), is(reduced));
    }

    @Test
    public void testPlusReturnsSum () {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertThat(five, is(sum.augend));
        assertThat(five, is(sum.addend));
    }

    @Test
    public void testReduceSum () {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(Money.dollar(7), is(result));
    }

    @Test
    public void testReduceMoney () {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(Money.dollar(1), is(result));
    }

    @Test
    public void testReduceMoneyDifferentCurrency () {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(Money.dollar(1), is(result));
    }

    @Test
    public void testIdentityRate () {
        assertThat(1, is (new Bank().rate("USD", "USD")));
    }

    @Test
    public void testMixedAddition () {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(Money.dollar(10), is (result));
    }
}