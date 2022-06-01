package com.mucho;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
/*        Node root = new Node("^");
        root.setLeft(new Node("*"));
        root.setRight(new Node("/"));
        root.getLeft().setLeft(new Node("-"));
        root.getLeft().setRight(new Node ("5"));
        root.getRight().setLeft(new Node("21"));
        root.getRight().setRight(new Node("7"));
        root.getLeft().getLeft().setLeft(new Node("10"));
        root.getLeft().getLeft().setRight(new Node("5"));

        System.out.println(TreeCalculator.evaluateTree(root));
        */

        String str = "-10 + 4";
        System.out.println(InfixToPostfix.convertToPostfix(str));
        }

    }

