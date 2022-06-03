package com.mucho;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixToTree {

    // methods are static so that no instantiation of a PostfixToTree object is necessary

    // tokenize the input expression (because of the implementation of InfixToPostfix, the input will always have spaces between each term)
    // if symbol is negation, create a one-child tree with negation symbol as root and the digits of the number as the left child
    // if symbol is operand, create one node tree and push it onto stack
    // if symbol is operator, pop two trees (nodes) T1 and T2 from stack
        // form new tree with root being operator, and left and right children being T2 and T1 respectively
    // push new tree onto stack
    // continue reading expression until there are no more symbols, at which point we should have an expression tree
    public static Node convertPostfixToTree(String expression){
        StringTokenizer expressionTokenized = new StringTokenizer((expression));
        Stack<Node> nodeStack = new Stack<Node>();
        while (expressionTokenized.hasMoreTokens()){
            String currentToken = expressionTokenized.nextToken();
            if (currentToken.charAt(0) == '~'){ // if the first character is "~", it means that we're negating the following number
                Node OperandNode = new Node(currentToken.substring(1)); // substring starts at 1 so that the ~ operator isn't included - we'll add the ~ in as a root to the parent in the next few lines
                nodeStack.push(OperandNode);
                Node operand = nodeStack.pop(); // if handling negation, we only pop one operand since negation is a unary operation
                Node NegationTree = new Node("~", operand);
                nodeStack.push(NegationTree);
            } else if (isNumeric(currentToken)){ // if the current token is numeric, it's an operand which means it gets pushed onto the stack and we move on to the next token
                Node OperandNode = new Node(currentToken);
                nodeStack.push(OperandNode);
            } else { // if the current token isn't a negative number and it's not an operand, it must be an operator
                Node T1 = nodeStack.pop();
                Node T2 = nodeStack.pop();
                Node OperatorTree = new Node(currentToken, T2, T1); // when encountering an operand, we pop trees/nodes T1 and T2 from the stack, then create a new tree with the operand as root and T1/T2 as children
                nodeStack.push(OperatorTree); // after creating the new tree, push it back onto the stack
            }
        }
        return nodeStack.pop(); // at this point there should be exactly one node remaining on the stack, the complete expression tree
    }

    // helper method to determine if a string object is numeric
    public static boolean isNumeric (String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex){ // if this exception happens, it means that whatever we attempted to read as a double isn't actually a number
            return false;
        }
    }

    // just a helper method so that i can verify correctness of an expression tree
    // traversing an expression tree in postorder gives postfix expression, so using this method we should be able to test to see if a given tree is correct
    // if the expression tree is correctly constructed, a postorder traversal should result in the postfix expression
    // passing in a StringBuilder as an argument and appending to it so that we can use the resulting string in unit tests
    public static void postorderTraversal(Node root, StringBuilder sb){
        if (root == null){
            return;
        }
        postorderTraversal(root.getLeft(), sb);
        postorderTraversal(root.getRight(), sb);
        sb.append(root.getData() + " "); // "root" doesn't necessarily have to be an actual root node, as we're traversing the entire tree including leaf nodes
    }
}
