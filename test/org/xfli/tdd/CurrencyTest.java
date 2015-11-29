package org.xfli.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void should1USDEquals1andhalfCHF () {
        Dollar dollar = new Dollar(1) ;
        assertThat(new Dollar(1.5), is(dollar.rate(1.5)));

        assertThat(new Dollar(2), is(dollar.rate(2)));
    }

    @Test
    public void shouldItBeAValueObject () {
        assertThat(true, is((new Dollar(1)).equals(new Dollar(1))));
    }

    @Test
    public void testEquality () {
        assertThat(true, is((new Dollar(1)).equals(new Dollar(1))));
        assertThat(false, is((new Dollar(1)).equals(new Dollar(2))));
        assertThat(true, is((new Franc(1)).equals(new Franc(1))));
        assertThat(false, is((new Franc(1)).equals(new Franc(2))));
    }
}