package com.mucho;

import org.junit.Test;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfix {

    // again, methods are static so that no instantiation is necessary

    private static final String operators = "-+/*^"; // this does NOT include our negation operator (~), since that must be processed differently
    private static final String operands = "0123456789"; // this could be extended to include letters, but for this assessment i kept it to just numbers


    public static String convertToPostfix(String infixExpr){
        String exprNoWhiteSpaces = infixExpr.replaceAll("\\s+",""); // doing this so the program has a uniform format with no spaces - otherwise it could get tripped up by expressions like "3 /4"
        StringBuilder negationsConverted = new StringBuilder();

        for (int i = 0 ; i < exprNoWhiteSpaces.length() ; i++){ // this part of the method converts unary negative operators in an expression to the symbol we'll be using to denote them, which is ~
            if (exprNoWhiteSpaces.charAt(i) == '-') { // if the very first character of the expression is "-", it must be negation
                if (i == 0) {
                    negationsConverted.append('~');
                } else if (isOperator(exprNoWhiteSpaces.charAt(i - 1))) { // if the character before "-" is an operator, then "-" must be a negation
                    negationsConverted.append('~');
                } else if (exprNoWhiteSpaces.charAt(i - 1) == '(') { // similar to the first case, as an expression inside parentheses is essentially a nested expression
                    negationsConverted.append('~');
                } else {
                    negationsConverted.append(exprNoWhiteSpaces.charAt(i)); // if none of the above cases are met, "-" must mean subtraction
                }
            } else {
                negationsConverted.append(exprNoWhiteSpaces.charAt(i)); // if current character isn't "-", append it and proceed
            }
        }

        StringBuilder output = new StringBuilder();
        Stack<Character> characterStack = new Stack<Character>();

        for (int i = 0; i < negationsConverted.length(); i++){
            if (negationsConverted.charAt(i) == '~'){
                output.append('~'); // if we encounter a negation symbol, we want to keep it right in front of the number it's negating for tokenizing purposes
            } else if (isOperator(negationsConverted.charAt(i))){ // if the current character is one of the operators in the "operators" string
                while (!characterStack.isEmpty() && characterStack.peek() != '('){ // while there are characters in the stack and the top one isn't "(", pop everything in the stack until either stack is empty or we reach a "("
                    if (operatorGreaterOrEqual(characterStack.peek(), negationsConverted.charAt(i))){ // if precedence of operator on stack is greater than or equal to precedence of incoming operator
                        output.append(characterStack.pop());
                        output.append(' '); // since an operator is being popped, add a space after it
                    } else { // if precedence of operator on stack is less than precedence of incoming operator, break from the while loop
                        break;
                    }
                }
                characterStack.push(negationsConverted.charAt(i)); // push character at current index (which is an operator) onto stack
            } else if (negationsConverted.charAt(i) == '('){
                characterStack.push(negationsConverted.charAt(i));
            } else if (negationsConverted.charAt(i) == ')'){
                while (!characterStack.isEmpty() && characterStack.peek() != '(') { // very similar to line 40, keep going until a "(" is reached
                    output.append(characterStack.pop());
                    output.append(' '); // again, operator is being popped so add a space
                }
                if (!characterStack.isEmpty()) {
                    characterStack.pop(); // not actually doing anything with the character at top of stack, just getting rid of it since it's a "(" and not included in the final postfix expression
                }
            } else if (Character.isDigit(negationsConverted.charAt(i))) { // if character is a digit (operand), just append it to the output
                output.append(negationsConverted.charAt(i));

                // the second condition checks to see if there's another digit/operand following the one we just scanned - if there's no digit or no more characters, append a space
                // if there is a digit following current character, it means that we're scanning in a multiple digit number and to keep scanning without adding a space
                // "i+1 >= negationsconverted.length()" is necessary to avoid a StringIndexOutOfBoundsException
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
        if (operator == '-' || operator == '+') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        else if (operator == '^'){
            return 3;
        } else return 0; // if we get here, it means that the character is not a binary operator
    }

    private static boolean operatorGreaterOrEqual(char op1, char op2)
    {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    private static boolean isOperator(char val) // if the character is an operator included
    {
        return operators.indexOf(val) >= 0;
    }

    private static boolean isOperand(char val)
    {
        return operands.indexOf(val) >= 0;
    }

}
