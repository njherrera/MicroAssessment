package com.mucho;

import java.util.Scanner;

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
            } else if (!input.equals("")) { // if input is not blank, process it
                String postfix = InfixToPostfix.convertToPostfix(input);
                Node root = PostfixToTree.convertPostfixToTree(postfix);
                System.out.println(TreeCalculator.evaluateTree(root));
            } else {
                System.out.println("Enter an expression"); // if input is blank, prompt user
                }
                // catching generic exception since there are multiple ways that an input could be invalid
            } catch (Exception ex){ // with more time, one change I would make is figuring out each possible exception, then printing a prompt based on the specific exception
                System.out.println("Please enter a valid input");
            }
        }

        }

    }

