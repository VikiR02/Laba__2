package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test(expected = Exception.class)
    public void cannotBeDividedBy0() {
        var calculator = new Calculator();
        calculator.calculate("6/0");
    }

    @Test
    public void rightNumberWriting(){
        var calculator = new Calculator();
        int exp= calculator.calculate("018");
        assertEquals(18,exp);
    }
}