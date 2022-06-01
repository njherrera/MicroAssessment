package com.mucho;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixToTree {

/*    personal notes:
    when generating tree, pop only one operand for negation (which one?)
        */
    // this class needs a method to turn a postfix expression into an expression tree

    // read the expression one symbol at a time
    // if symbol is operand, create one node tree and push it onto stack
    // if symbol is operator, pop two trees (nodes) T1 and T2 from stack
        // form new tree with root being operator, and left and right children being T2 and T1 respectively
    // push new tree onto stack
    // continue reading expression until there are no more symbols, at which point we should have an expression tree
    public Node convertPostfixToTree(StringTokenizer expression){
        Stack<Node> nodeStack = new Stack<Node>();
        while (expression.hasMoreTokens()){
            String currentToken = expression.nextToken();
            if (isNumeric(currentToken)){
                Node newOperandNode = new Node(currentToken);
                nodeStack.push(newOperandNode);
            } else {
                Node T1 = nodeStack.pop();
                Node T2 = nodeStack.pop();
                Node newOperatorTree = new Node(currentToken, T2, T1);
                nodeStack.push(newOperatorTree);
            }
        }
        return nodeStack.pop();
    }

    // helper method to determine if a string object is numeric
    public static boolean isNumeric (String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
