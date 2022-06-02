package com.mucho;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixToTreeTest {

    @Test
    void postorderTraversalTest(){
        String infix = "(2+1)-(4*2)";
        StringBuilder sb = new StringBuilder();
        String postfixExpression = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfixExpression);
        PostfixToTree.postorderTraversal(root, sb);
        assertEquals("2 1 + 4 2 * -", sb.toString().trim());
    }

    @Test
    void POTraversalTestExponentNegative(){
        String infix = "(-4+3^2)-(4*2)/3";
        StringBuilder sb = new StringBuilder();
        String postfixExpression = InfixToPostfix.convertToPostfix(infix);
        Node root = PostfixToTree.convertPostfixToTree(postfixExpression);
        PostfixToTree.postorderTraversal(root, sb);
        assertEquals("4 ~ 3 2 ^ + 4 2 * 3 / -", sb.toString().trim());
        // here the technically correct postfix notation we're looking for with the negation in front of the 4 doesn't work
        // if this was preorder traversal the negation would be in front of the four
        // since this is postorder traversal the root is visited last, meaning that the negation symbol is printed immediately after the operand it's negating
    }

}