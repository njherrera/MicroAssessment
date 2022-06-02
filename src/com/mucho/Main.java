package com.mucho;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a valid infix expression");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            try{
            String input = sc.nextLine();
            if (input.equals("EXIT")) {
                    sc.close();
                    break;
            } else if (!input.equals("")) {
                String postfix = InfixToPostfix.convertToPostfix(input);
                Node root = PostfixToTree.convertPostfixToTree(postfix);
                System.out.println(TreeCalculator.evaluateTree(root));
            } else {
                System.out.println("Enter an expression");
                }
            } catch (Exception ex){ // catching generic exception since there are multiple ways that an input could be invalid
                System.out.println("Please enter a valid input");
            }
        }

        }

    }

