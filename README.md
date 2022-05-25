# MicroAssessment

APPROACHING THE ASSESSMENT

My first step in the process is to determine the structure of the project in terms of classes. My inclination is that all this project needs is a Main class and a Calculator class, but we'll see how that changes. In order to determine how to structure the classes, it's important to think about how the program will actually parse a given mathematical expression. Figuring this out will dictate the code's structure, specifically if I want to have the expression-parsing logic be in its own class. To do this, I started by going through the supplied example expressions top to bottom (easiest to hardest) and working through them mentally. As a side note, the part of this assessment that I see being the most difficult is finding a way to handle parentheses - I need to implement some way to check for parentheses, extract the expression inside them, then calculate the expression. To do this, I will likely need to use some sort of regular expression to split up the supplied mathematical expression - for example, with the example expression "(2 + 1) - (4 * 2)" we need to split the expression such that we end up with "{(2+1)}, {-}, {(4*2)}". After splitting the expression, we then work through it with the Calculator class's logic.

After thinking about my approach to the assessment more by working through parsing expressions, I think that going with two classes, Main, and Calculator is the best approach. I don't envision writing too many lines of code or methods (essentially just a parsing/splitting method, an overarching Calculate method, and one method for each operator that is called by the Calculate method), so based off that I don't think it'll be necessary to split up the code into smaller classes. However, splitting code into smaller and abstract classes would allow for easier extension of the code to add more operators - this is very relevant, especially in a collaborative environment where multiple people are working on the same project.


PARSING EXPRESSIONS


My first inclination is to do some sort of split to separate parts of the expression and/or checking to see if the expression contains "+", "-", "^", or "()", as well as cut out all the white spaces (this allows us to more cleanly work with the expression). The first step is cutting out all the white spaces, which calls for a fairly straightforward use of Java's replaceAll method. After a brief test in my Main method, I have verified that it works and the first step of parsing expressions is finished. Now that we have the expression without white spaces, parsing it should be significantly easier. 

After some more thinking, I'm realizing that using replaceAll to get rid of white spaces won't actually work. My initial approach was to loop through the expression until I find an operator, then compute the result of the number at the index before, the operator, and the number at the index after. If a number is more than one digit, this approach will only factor the last digit into the expression. 

USING AN EXPRESSION TREE

While looking into ways to parse mathematical expressions, I came across a new approach - representing the expression as a binary tree, then evaluating it by performing a traversal, the type of traversal depending on whether the expression is represented as prefix, infix, or postfox notation. This approach seems significantly easier, especially when it comes to evaluating parentheses and negative numbers. At this point I'm researching expression trees and how to construct them, since it's been a little while since I encountered them. This implementation seems relatively straightforward, with the exception of handling exponents - finding examples of expression trees that handle exponents is proving to be somewhaat difficult. 

After some further research I did find a source that uses exponents in an example, and it seems to be fairly clean - just treat "^" as another operator. For example, taking the expression "3^2", all one needs to do is have the "^" be the root node, and have "3" and "2" be its children/leaf nodes.


