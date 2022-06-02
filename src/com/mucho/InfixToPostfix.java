package com.mucho;

import org.junit.Test;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfix {
    private static final String operators = "-+/*^";
    private static final String operands = "0123456789";


    public static String convertToPostfix(String infixExpr){
        String exprNoWhiteSpaces = infixExpr.replaceAll("\\s+","");
        StringBuilder negationsConverted = new StringBuilder();

        for (int i = 0 ; i < exprNoWhiteSpaces.length() ; i++){ // this part of the method converts unary negative operators to the symbol we'll be using to denote them, which is ~
            if (exprNoWhiteSpaces.charAt(i) == '-') {
                if (i == 0) {
                    negationsConverted.append('~');
                } else if (isOperator(exprNoWhiteSpaces.charAt(i - 1))) {
                    negationsConverted.append('~');
                } else if (exprNoWhiteSpaces.charAt(i - 1) == '(') {
                    negationsConverted.append('~');
                } else {
                    negationsConverted.append(exprNoWhiteSpaces.charAt(i));
                }
            } else {
                negationsConverted.append(exprNoWhiteSpaces.charAt(i));
            }
        }

        StringBuilder output = new StringBuilder();
        Stack<Character> characterStack = new Stack<Character>();

        for (int i = 0; i < negationsConverted.length(); i++){
            if (negationsConverted.charAt(i) == '~'){
                output.append('~');
            } else if (isOperator(negationsConverted.charAt(i))){
                while (!characterStack.isEmpty() && characterStack.peek() != '('){
                    if (operatorGreaterOrEqual(characterStack.peek(), negationsConverted.charAt(i))){
                        output.append(characterStack.pop());
                        output.append(' ');
                    }
                    else{
                        break;
                    }
                }
                characterStack.push(negationsConverted.charAt(i));
            } else if (negationsConverted.charAt(i) == '('){
                characterStack.push(negationsConverted.charAt(i));
            } else if (negationsConverted.charAt(i) == ')'){
                while (!characterStack.isEmpty() && characterStack.peek() != '(') {
                    output.append(characterStack.pop());
                    output.append(' ');
                }
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                }
            } else if (Character.isDigit(negationsConverted.charAt(i))) {
                output.append(negationsConverted.charAt(i));

                if (i+1 >= negationsConverted.length() || !Character.isDigit(negationsConverted.charAt(i+1))) {
                    output.append(' ');
                }
            }
        }
        while (!characterStack.empty()){
            output.append(characterStack.pop());
            output.append(' ');
        }
        return output.toString();
    }

    private static int getPrecedence(char operator){
        if (operator == '~') {
            return 0;
        }
        if (operator == '-' || operator == '+') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        else if (operator == '^'){
            return 3;
        } else return 0; // if we get here, it means that the character is an operand
    }

    private static boolean operatorGreaterOrEqual(char op1, char op2)
    {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    private static boolean isOperator(char val)
    {
        return operators.indexOf(val) >= 0;
    }

    private static boolean isOperand(char val)
    {
        return operands.indexOf(val) >= 0;
    }

}
