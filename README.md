# MicroAssessment

APPROACHING THE SOLUTION

While looking into ways to parse mathematical expressions, I came across an approach I learned in my Data Structures class in college - representing the expression as a binary tree, then evaluating it by performing a traversal, the type of traversal depending on whether the expression is represented as prefix, infix, or postfox notation. This approach seems fairly straightforward, especially when it comes to evaluating parentheses and negative numbers. At this point I'm researching expression trees and how to construct them by looking at algorithms and data structures textbooks, since it's been a little while since I encountered them. This implementation seems relatively straightforward, with the possible exception being handling negative numbers - when looking for examples of expression trees I found examples that expressed both exponents and parentheses, but not negative numbers.

Since an expression tree is just a form of a binary tree, my first step for this solution is to figure out the pseudocode (either directly from a textbook or based off their explanation) for building a binary tree. After this, I will again look in the textbooks to see if building an expression tree is at all different than building a normal binary tree, if at all. From this pseudocode I will write the actual code myself, although I expect that I will need to look up some documentation in order to do so. At this point it seems like the main textbook I'll be using is Data Structures and Algorithm Analysis in Java by Mark Weiss, as it has sections on both generating an expression tree from postfix notation, as well as a section on infix to postfix conversion.

Something I am realizing is that while Weiss's explanation of building an expression tree is good in general, it does not cover how to build a tree from an expression that includes a negative number (although he does mention that it is possible to include unary opearators in an expression tree). Weiss also does not talk about how to evaluate the result of an expression tree, so it looks like I'll have to fill in the gaps of Weiss's text with 

CLASS STRUCTURE

Since I'll be using Weiss's expression tree method that uses postfix notation, I will likely at bare minimum need a Node class, a class concerned with parsing an infix expression and turning it into an expression tree, and a Main class which runs a scanner that reads the user's input and calculates it. A Calculator class that actually computes and outputs the value of a given expression tree is also required to me personally, as I want to avoid putting actual methods/logic besides the scanner in Main.



