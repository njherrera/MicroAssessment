package com.mucho;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {

    @Test
    void firstExampleTest() {
        assertEquals("1 1 +", InfixToPostfix.convertToPostfix("1+1").trim());
    }

    @Test
    void secondExampleTest(){
        assertEquals("3 4 /", InfixToPostfix.convertToPostfix("3 /4").trim());
    }

    @Test
    void thirdExampleTest(){
        assertEquals("2 1 + 4 2 * -", InfixToPostfix.convertToPostfix("(2+1)-(4*2)").trim());
    }

    @Test
    void fourthExampleTest(){
        assertEquals("~10 4 +", InfixToPostfix.convertToPostfix("-10 + 4").trim());
    }

    @Test
    void simpleExponentTest(){
        assertEquals("10 5 ^", InfixToPostfix.convertToPostfix("10^5").trim());
    }

    @Test
    void complexExponentTest(){
        assertEquals("3 5 * 3 4 2 ^ + -", InfixToPostfix.convertToPostfix("3*5-(3+4^2)").trim());
    }
}