package com.mucho;

public class TreeCalculator {

    // personal notes
    // evaluation only looks at left child for negation (negation operator will always only have left child)

    // since the tree was constructed from postfix notation, we'll be evaluating it using a postorder traversal
    // making methods static so that we don't have to instantiate a TreCalculator object
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
        return processOperator(root.getData(), x, y);
    }

    public static double processOperator(String operator, double leftNodeValue, double rightNodeValue){
        if (operator.equals("+")){
            return leftNodeValue + rightNodeValue;
        }
        if (operator.equals("-")){
            return leftNodeValue - rightNodeValue;
        }
        if (operator.equals("*")){
            return leftNodeValue * rightNodeValue;
        }
        if (operator.equals("/")){
            return leftNodeValue / rightNodeValue;
        }
        if (operator.equals("^")){
            return Math.pow(leftNodeValue, rightNodeValue);
        }
        return 0; // if we get to here, it means that something has gone wrong
    }
}
