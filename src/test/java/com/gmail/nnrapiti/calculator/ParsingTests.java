package com.gmail.nnrapiti.calculator;

import org.junit.jupiter.api.Test;

import static com.gmail.nnrapiti.calculator.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingTests {

    @Test
    public void getFirstNumberSingleDigit(){
        String[] args = new String[]{"5"};
        assertEquals(5, getXFromArgs(args));
    }
    @Test
    public void getFirstNumberMultipleDigitSameSpace(){
        String[] args = new String[]{"38"};
        assertEquals(38, getXFromArgs(args));
    }

    @Test
    public void getFirstNumberMultipleDigitDifferentSpace(){
        String[] args = new String[]{"3", "8"};
        assertEquals(38, getXFromArgs(args));
    }
    @Test
    public void getFirstNumberMultipleDigitDifferentSpaceQuiteAFewNumbers(){
        String[] args = new String[]{"3", "8", "9", "7", "4", "2", "3"};
        assertEquals(3897423, getXFromArgs(args));
    }

    @Test
    public void getFirstNumberSingleDigitWithOperator(){
        String[] args = new String[]{"5", "ADD"};
        assertEquals(5, getXFromArgs(args));
    }

    @Test
    public void getFirstNumberMultipleDigitSameSpaceWithOperator(){
        String[] args = new String[]{"38", "ADD"};
        assertEquals(38, getXFromArgs(args));
    }

    @Test
    public void getFirstNumberMultipleDigitDifferentSpaceWithOperator(){
        String[] args = new String[]{"3", "8", "ADD"};
        assertEquals(38, getXFromArgs(args));
    }

    @Test
    public void getOperatorADD(){
        String[] args = new String[]{"5", "ADD"};
        assertEquals("ADD", getOperatorFromArgs(args));
    }

    @Test
    public void getOperatorMINUS(){
        String[] args = new String[]{"5", "MINUS"};
        assertEquals("MINUS", getOperatorFromArgs(args));
    }

    @Test
    public void getSecondNumberSingleDigit(){
        String[] args = new String[]{"5", "ADD", "3"};
        assertEquals(3, getYFromArgs(args));
    }
    @Test
    public void getSecondNumberMultipleDigitSameSpace(){
        String[] args = new String[]{"38", "MINUS", "65"};
        assertEquals(65, getYFromArgs(args));
    }

    @Test
    public void getSecondNumberMultipleDigitDifferentSpace(){
        String[] args = new String[]{"3", "8", "ADD", "5", "6"};
        assertEquals(56, getYFromArgs(args));
    }
    @Test
    public void getSecondNumberMultipleDigitDifferentSpaceQuiteAFewNumbers(){
        String[] args = new String[]{"3", "8", "9", "7", "4", "2", "3", "ADD", "2", "3", "9", "7", "9", "7"};
        assertEquals(239797, getYFromArgs(args));
    }

    @Test
    public void addNumbersUsingStringArray(){
        String[] args = new String[]{"6", "ADD", "5"};
        int x = getXFromArgs(args);
        int y = getYFromArgs(args);
        int result = addNumbers(x, y);
        assertEquals(11, result);

    }

}
