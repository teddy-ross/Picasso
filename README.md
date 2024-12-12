# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.

The given code base is a good start, but it is sparsely documented
(document each method/part after you understand what it's doing), and,
as your application grows, you may need to refactor.

See the specification for Picasso on the course web site.

# Team Members
Nisha Walvekar

Sanjog Basnet

Sarina Cusumano

Sylvia Agatako

Teddy Ross
## Running Picasso

To run Picasso, run `picasso.Main`

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

`images` - contains some sample images generated from Picasso. Some of the expressions for these images can be found in the `expressions` directory.

## Code Base History

This code base originated as a project in a course at Duke University.  The professors realized that the code could be designed better and refactored.  This code base has some code leftover from the original version.

## Extensions
1. User can use the Up and Down arrow keys to navigate through the expression that they have evaluated in the current session.
2. Generate expressions randomly - User can press the random button, which will create and show a randomly generated expression in the textfield. You can then evaluate by pressing the button or focusing the text box and hitting enter.
3. User can use command/cntrl and +/- to zoom in and out of the image. User must click into text box.
4. User can animate a function by typing animate(<expression>)
5. User can view multiple images in various tabs. By clicking "New Tab" in the frame, they can create a new canvas and evaluate an expression to get an image. 
