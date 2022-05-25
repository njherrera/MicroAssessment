# MicroAssessment

APPROACHING THE ASSESSMENT

My first step in the process is to determine the structure of the project in terms of classes. My inclination is that all this project needs is a Main class and a Calculator class, but we'll see how that changes. In order to determine how to structure the classes, it's important to think about how the program will actually parse a given mathematical expression. Figuring this out will dictate the code's structure, specifically if I want to have the expression-parsing logic be in its own class. To do this, I started by going through the supplied example expressions top to bottom (easiest to hardest) and working through them mentally. As a side note, the part of this assessment that I see being the most difficult is finding a way to handle parentheses - I need to implement some way to check for parentheses, extract the expression inside them, then calculate the expression.

USING AN EXPRESSION TREE

While looking into ways to parse mathematical expressions, I came across an approach I learned in my Data Structures class in college - representing the expression as a binary tree, then evaluating it by performing a traversal, the type of traversal depending on whether the expression is represented as prefix, infix, or postfox notation. This approach seems significantly easier, especially when it comes to evaluating parentheses and negative numbers. At this point I'm researching expression trees and how to construct them, since it's been a little while since I encountered them. This implementation seems relatively straightforward, with the exception of handling exponents - finding examples of expression trees that handle exponents is proving to be somewhaat difficult. 

After some further research I did find a source that uses exponents in an example, and it seems to be fairly clean - just treat "^" as another operator. For example, taking the expression "3^2", all one needs to do is have the "^" be the root node, and have "3" and "2" be its children/leaf nodes.


