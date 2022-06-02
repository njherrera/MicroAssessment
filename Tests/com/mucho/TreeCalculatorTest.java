package com.mucho;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeCalculatorTest {

    @Test
    void firstExampleTest(){
        String infix = "1+1";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(2, TreeCalculator.evaluateTree(root));
    }

    @Test
    void secondExampleTest(){
        String infix = "3 /4";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(.75, TreeCalculator.evaluateTree(root));
    }

    @Test
    void thirdExampleTest(){
        String infix = "(2+1)-(4*2)";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(-5, TreeCalculator.evaluateTree(root));
    }

    @Test
    void fourthExampleTest(){
        String infix = "-10 + 4";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(-6, TreeCalculator.evaluateTree(root));
    }

    @Test
    void simpleExponentTest(){
        String infix = "10^5";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(100000, TreeCalculator.evaluateTree(root));
    }

    @Test
    void complexExponentTest(){
        String infix = "3 * 5 - (3 + 4^2)";
        String postfix = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfix);
        assertEquals(-4, TreeCalculator.evaluateTree(root));
    }

}