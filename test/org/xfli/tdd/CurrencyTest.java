package org.xfli.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void should1USDEquals1andhalfCHF () {
        Currency currency = new Currency(1) ;
        currency.rate(1.5) ;
        assertThat(1.5, is(currency.amount));

        currency.rate(2);
        assertThat(3.0, is(currency.amount));

    }

}