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
        assertThat(true, is((new Dollar(1)).equals(new Dollar(1))));
        assertThat(false, is((new Dollar(1)).equals(new Dollar(2))));
        assertThat(true, is((new Franc(1)).equals(new Franc(1))));
        assertThat(false, is((new Franc(1)).equals(new Franc(2))));
        assertThat(false, is((new Dollar(1)).equals(new Franc(1))));
    }

    @Test
    public void testCurrency () {
        assertThat("USD", is(Money.dollar(0).currency));
        assertThat("CHF", is(Money.franc(0).currency));
    }
}