package com.mucho;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
/*        Node root = new Node("+");
        root.setLeft(new Node("~"));
        root.getLeft().setLeft(new Node("3"));
        root.setRight(new Node("*"));
        root.getRight().setLeft(new Node("+"));
        root.getRight().setRight(new Node("2"));
        root.getRight().getLeft().setLeft(new Node("5"));
        root.getRight().getLeft().setRight(new Node("9"));

        System.out.println(TreeCalculator.evaluateTree(root));*/

        String infix = "-3+((5+9)*-2^2)";
        System.out.println(TreeCalculator.evaluateTree(PostfixToTree.convertPostfixToTree(InfixToPostfix.convertToPostfix(infix))));
        }

    }

