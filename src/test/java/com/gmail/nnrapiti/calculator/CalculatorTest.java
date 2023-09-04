package com.gmail.nnrapiti.calculator;

import org.junit.jupiter.api.Test;

import static com.gmail.nnrapiti.calculator.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void additionFunction(){
        int result = addNumbers(5, 11);
        assertEquals(16, result);
    }

    @Test
    public void subtractionFunction(){
        int result = subtractNumbers(11, 5);
        assertEquals(6, result);
    }

    @Test
    public void multiplicationFunction(){
        int result = multiplyNumbers(25, 3);
        assertEquals(75, result);
    }

    @Test
    public void divisionFunction(){
        int result = divideNumbers(33, 11);
        assertEquals(3, result);
    }

    @Test
    public void performMultiply(){
        int x = 5;
        int y = 2;
        String operation = "MULTIPLY";
        int result = doOperation( x, operation, y);
        assertEquals(10, result);
    }

    @Test
    public void performAddition(){
        int x = 17;
        int y = 2;
        String operation = "ADD";
        int result = doOperation( x, operation, y);
        assertEquals(19, result);
    }
    @Test
    public void performSubtract(){
        int x = 17;
        int y = 2;
        String operation = "SUBTRACT";
        int result = doOperation( x, operation, y);
        assertEquals(15, result);
    }
    @Test
    public void performDivide(){
        int x = 15;
        int y = 3;
        String operation = "DIVIDE";
        int result = doOperation( x, operation, y);
        assertEquals(5, result);
    }

    @Test
    public void performUnknownOperation(){
        int x = 15;
        int y = 3;
        String operation = "UNKNOWN";
        assertThrows(IllegalStateException.class, ()-> doOperation( x, operation, y) );
    }



}
