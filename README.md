# MicroAssessment

APPROACHING THE SOLUTION

While looking into ways to parse mathematical expressions, I came across an approach I learned in my Data Structures class in college - representing the expression as a binary tree, then evaluating it by performing a traversal, the type of traversal depending on whether the expression is represented as prefix, infix, or postfox notation. This approach seems fairly straightforward, especially when it comes to evaluating parentheses and negative numbers. At this point I'm researching expression trees and how to construct them by looking at algorithms and data structures textbooks, since it's been a little while since I encountered them. This implementation seems relatively straightforward, with the possible exception being handling negative numbers - when looking for examples of expression trees I found examples that expressed both exponents and parentheses, but not negative numbers.

Since an expression tree is just a form of a binary tree, my first step for this solution is to figure out the pseudocode (either directly from a textbook or based off their explanation) for building a binary tree. After this, I will again look in the textbooks to see if building an expression tree is at all different than building a normal binary tree, if at all. From this pseudocode I will write the actual code myself, although I expect that I will need to look up some documentation in order to do so. At this point it seems like the main textbook I'll be using is Data Structures and Algorithm Analysis in Java by Mark Weiss, as it has sections on both generating an expression tree from postfix notation, as well as a section on infix to postfix conversion.

Something I am realizing is that while Weiss's explanation of building an expression tree is good in general, it does not cover how to build a tree from an expression that includes a negative number (although he does mention that it is possible to include unary opearators in an expression tree). Weiss also does not talk about how to evaluate the result of an expression tree, so it looks like I'll have to fill in the gaps of Weiss's text with 

CLASS STRUCTURE

Since I'll be using Weiss's expression tree method that uses postfix notation, I will likely at bare minimum need a Node class, a class concerned with parsing a postfix expression and turning it into an expression tree (PostfixToTree),  a class that converts infix notiaton into postfix notation (InfixToPostfix), and a Main class which runs a scanner that reads the user's input and calculates it. A TreeCalculator class that actually computes and outputs the value of a given expression tree is also required to me personally, as I want to avoid putting actual methods/logic besides the scanner in Main.

As a side note, one of my goals for this asssessment is to write as much of my own code as possbile - hence studying Weiss's textbook to learn how to generate an expression tree instead of just copying implementation from online. However, given that this approach has already taken me quite a while (I estimate a solid hour and a half for finding a textbook that covers what I'm trying to implement, studying it, and finally figuring out pseudocode), I don't think that I'll be able to follow this approach for the rest of the assignment. While reinventing the wheel (so to speak) would be very satisfying, at this point I have to go with the solution that makes the most sense time-wise. As such, I will also be studying other people's implementation of evaluating the result of an expression tree as well as turning infix notation into postfix notation.


CONSTRUCTING AN EXPRESSION TREE 

This step was fairly straightforward, as looking at Weiss's textbook gave me a pretty clear direction for constructing an expression tree from postfix notation. The hardest part of constructing the tree that I have yet to do is adding handling for some sort of negation operator - to solve the issue of handling double digit numbers, the plan is to tokenize the input, splitting it up into pieces. I may have to use some sort of regular expression to properly tokenize an input, but that shouldn't be too difficult to do. My plan is to work on PostfixConverter and TreeCalculator (converting infix to postfix and evaluating an expression tree) to get a prototype up and running, then add in support for negation later.

EVALUATING AN EXPRESSION TREE

This was also fairly straightforward, as there's a lot of material online regarding evaluating expression trees. I made some modifications to an established format, adding support for the "^" operator. After finishing work on converting infix expressions to postfix expressions, I'll have to go back to constructing and evaluating an expression tree to add support for the unary negative operator, which I'll be representing with "~".

CONVERTING INFIX TO POSTFIX

This is likely the hardest part of the solution, as not only do I need to handle the unary negation operator but double digit numbers as well. As I'm having a hard time locating sources that provide instructions on how to handle both at the same time, my plan is to find sources that handle each individually and then combine them into one piece. As a result, I have to do some independent thinking to figure out how I can modify existing code to accomplish my goals, which requires going deep in the code (so to speak) and analyzing how the existing code works and then making the correct modifications.
