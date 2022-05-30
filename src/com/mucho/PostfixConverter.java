package com.mucho;

import java.util.Stack;

public class PostfixConverter {

    // this class needs a method to turn a postfix expression into an expression tree

    // read the expression one symbol at a time
    // if symbol is operand, create one node tree and push it onto stack
    // if symbol is operator, pop two trees (nodes) T1 and T2 from stack
        // form new tree with root being operator, and left and right children being T2 and T1 respectively
    // push new tree onto stack
    // continue reading expression until there are no more symbols, at which point we should have an expression tree
    public Node convertPostfixToTree(String expression){
        Stack<Node> nodeStack = new Stack<Node>();

    }
}
