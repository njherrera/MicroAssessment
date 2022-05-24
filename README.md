# MicroAssessment

Approaching the assessment

My first step in the process is to determine the structure of the project in terms of classes. My inclination is that all this project needs is a Main class and a Calculator class, but we'll see how that changes. In order to determine how to structure the classes, it's important to think about how the program will actually parse a given mathematical expression. Figuring this out will dictate the code's structure, specifically if I want to have the expression-parsing logic be in its own class. To do this, I started by going through the supplied example expressions top to bottom (easiest to hardest) and working through them mentally.

Parsing expressions

My first inclination is to do some sort of split to separate parts of the expression and/or checking to see if the expression contains "+", "-", "^", or "()", as well as cut out all the white spaces (this allows us to more cleanly work with the expression). The first step is cutting out all the white spaces, which calls for a fairly straightforward use of Java's replaceAll method.
