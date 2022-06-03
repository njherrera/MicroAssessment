package com.mucho;

public class TreeCalculator {

    // since the tree was constructed from postfix notation, we'll be evaluating it using a postorder traversal
    // making methods static so that we don't have to instantiate a TreeCalculator object
    public static double evaluateTree (Node root){
        if (root == null){
            return 0;
        }
        // if the node has no children, that means its a leaf node, which means its an operand
        if (root.getLeft() == null && root.getRight() == null){
            return Double.valueOf(root.getData());
        }
        // postorder traversal, getting left and right nodes first, then root node
        double x = evaluateTree(root.getLeft());
        double y = evaluateTree(root.getRight());
        if (root.getLeft() != null && root.getRight() != null) { // if root has both children, it's NOT the unary negative operator, so we can proceed as normal with the processOperator method
            return processOperator(root.getData(), x, y);
        } else return processTilde(root.getData(), x); // if a root doesn't have both children, it means that we're negating its left child
        // since every operator except negation is binary, they MUST have two children
    }

    public static double processOperator(String operator, double leftNodeValue, double rightNodeValue){
        if (operator.equals("+")){
            return leftNodeValue + rightNodeValue;
        }
        else if (operator.equals("-")){
            return leftNodeValue - rightNodeValue;
        }
        else if (operator.equals("*")){
            return leftNodeValue * rightNodeValue;
        }
        else if (operator.equals("/")){
            return leftNodeValue / rightNodeValue;
        }
        else if (operator.equals("^")){
            return Math.pow(leftNodeValue, rightNodeValue);
        } else return 0; // if we get to here, it means that something has gone wrong
    }

    // added a seperate method for processing negation, since its unary
    // theoretically this method could be extended to include support for other unary operators such as factorials
    public static double processTilde(String operator, double leftNodeValue){
        return leftNodeValue * -1;
    }
}
