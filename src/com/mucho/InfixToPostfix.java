package com.mucho;

import java.util.Stack;

public class InfixToPostfix {
    private static final String operators = "~-+/*^";
    private static final String operands = "0123456789";

    public static String convertToPostfix(String infixExpr){
        StringBuilder negationsConverted = new StringBuilder();
        Stack<Character> characterStack = new Stack<Character>();

        for (int i=0 ; i < infixExpr.length() ; i++){ // this part of the method converts unary negative operators to the symbol we'll be using to denote them, which is ~
            if (infixExpr.charAt(i) == '-'){
                if (isOperand(infixExpr.charAt(i+1))){
                    if (i != infixExpr.length()){
                        if (isOperator(infixExpr.charAt(i))) {
                            negationsConverted.append('~');
                        }
                    }
                    else{
                        negationsConverted.append(infixExpr.charAt(i));
                    }
                }
                else{
                    negationsConverted.append(infixExpr.charAt(i));
                }
            }
            else{
                negationsConverted.append(infixExpr.charAt(i));
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < negationsConverted.length(); i++){

            if (isOperator(negationsConverted.charAt(i))){
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
            }
            else if (negationsConverted.charAt(i) == '('){
                characterStack.push(negationsConverted.charAt(i));
            }
            else if (negationsConverted.charAt(i) == ')'){
                while (!characterStack.isEmpty() && characterStack.peek() != '(') {
                    output.append(characterStack.pop());
                    output.append(' ');
                }
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                }
            }
            else if (Character.isDigit(negationsConverted.charAt(i))) {
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

    public int evaluatePostfix(String postfixExpr)
    {
        char[] chars = postfixExpr.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for (char c : chars)
        {
            if (isOperand(c))
            {
                stack.push(c - '0'); // convert char to int val
            }
            else if (isOperator(c))
            {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result;
                switch (c) {
                    case '*':
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case '/':
                        result = op2 / op1;
                        stack.push(result);
                        break;
                    case '+':
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case '-':
                        result = op2 - op1;
                        stack.push(result);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private static int getPrecedence(char operator)
    {
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
