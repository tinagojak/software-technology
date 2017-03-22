package com.example.tinag.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    @Test
    public void testAddition(){
        int result = Calculations.doAddition(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testAddition1(){
        int result = Calculations.doAddition(-2, 3);
        assertEquals(1, result);
    }
    @Test
    public void testDoSubtraction(){
        int result = Calculations.doSubtraction(7, 2);
        assertEquals(5, result);
    }
    @Test
    public void testDoSubtraction1(){
        int result = Calculations.doSubtraction(2, 7);
        assertEquals(-5, result);
    }
    @Test
    public void testDoMultiplication(){
        int result = Calculations.doMultiplication(2, 3);
        assertEquals(6, result);
    }
    @Test
    public void testDoMultiplication1(){
        int result = Calculations.doMultiplication(-2, 3);
        assertEquals(-6, result);
    }
    @Test
    public void testDoDivision(){
        int result = Calculations.doDivision(8, 4);
        assertEquals(2, result);
    }
    @Test
    public void testDoDivision1(){
        int result = Calculations.doDivision(8, 0);
        assertEquals(0, result);
    }
    @Test
    public void testDoDivision2(){
        int result = Calculations.doDivision(11, 4);
        assertEquals(2, result);
    }
    @Test
    public void testDoDivision3(){
        int result = Calculations.doDivision(-8, 2);
        assertEquals(-4, result);
    }
}