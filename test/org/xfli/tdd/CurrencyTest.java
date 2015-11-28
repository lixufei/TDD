package org.xfli.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void should1USDEquals1andhalfCHF () {
        Currency currency = new Currency(1) ;
        assertThat(new Currency(1.5), is(currency.rate(1.5)));

        assertThat(new Currency(2), is(currency.rate(2)));
    }

    @Test
    public void shouldItBeAValueObject () {
        assertThat(true, is((new Currency(1)).equals(new Currency(1))));
    }

}