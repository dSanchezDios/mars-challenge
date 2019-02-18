> I've applied SOLID principles and TDD to develop the project, so here is the decisions that I wrote before start.

# ⚖️ ASSUMPTIONS

## I have assumed that:

1. Rovers and obstacles can not exist out of the map, that means an input with a rover out of the range will throw
   an IllegalArgumentException with a description.

2. Bottom left coordinates are (0, 0), so there is no negative coordinates, that means an input with negative 
   coordinates will throw an CoordinateException.

3. Rover has a position and a list of instructions, that means an input without position will throw an
   IllegalArgumentException.

4. With a plateau coordinates (X, Y), rover movements are not delimited, that means rover position (X+1, Y) will be
   (0,Y) and (X, Y+1) will be (X, 0) and same for (-1, Y) or (X, -1).
		    
			e.g.:
				- Map range:          (2, 3)
				- Obstacles empty.
			    - Rover position:     (1, 2, N)
			    - Rover instruction:  (f, f)
			    - Rover position after execute instructions: (1, 0, N)

5. I do not want the rover to run out of battery 🤖, that means between f's or b's:
        
        Turns in the same direction are optimized in groups of four. 

			e.g.:
			    - x8 r -> x0 r
			    - x9 r -> x1 r
			    - x10 r -> x2 r
			    - x11 r -> x3 r
			
        Turns r and l are opposite.

			e.g.:
			    - rlrlr -> R
			    - lllllllrr -> L
			    
6. When the next instruction move the rover to an obstacle it throw an RoveFoundObstacleException with the last valid
   position.
            
# 🎨 DESIGN
            
> With these assumptions I've written tests, main (AcceptationTest) who tests from beginning to end then project, 
  the rest of them are the ones that I, using TDD, have implemented the rest of classes.I started doing test for parse 
  the input, they they were "telling" me the objects I needed.

# Parsers package

> They parse string input and return new objects or throw exceptions.

## RoverParser
    It read the global input and calls the rest of parsers, if everything is OK it will return the Rover object that
    contains the list of instructions, position and map.

# Model package

> Where the OOP happens.

## Coordinate
    An immutable object with a number > 0, they can grow or decrement and be higher than other coordinate (methods
    return a new object).

## Dimension
    An immutable pair of coordinates, a dimension can increment and decrement its variables and tell if is out of range.

## Instruction
    Enum with the three different types, l, r, f, b.

## Orientation
    Enum with the four cardinals, each orientation has a right and a left.

## Map
    An immutable object with two variables: Dimension object for tell which is the size and obstacles (Dimension)
    hashSet (Why? -> Because it cant be two obstacles in the same square).

## Position
    An immutable group composed of a Dimension and one Orientation.

## Rover 
    Main object, with a position, map and a list of instructions. 
    
    Rovers can execute instructions list, this method execute instruction by instruction from the list and move, or turn
    depending of the instruction, at the end, it will return the actual position.
	
	Rovers also can execute a single instruction as in the example. I decided just read instructions and put movements
	private and just read the instruction I think is easier for the user :-).
	
# Utils package 
## InstructionListOptimizer
    Optimize the instruction list provided.
    
    	
# 🗣 Just saying

 >  About the legacy: I decided implement the intern code reads and moves the rover input by input but I would prefer
    to have just an instructions executor for arrays as the readme description… It didnt take me a big effort, it was a
    release instead of a implementation since it was done.

# RoversUtils

    Interface utils with static methods to make easier the parser injections to client.
    * launch: reads inputs and return the result of execute the rover as a String.
    * create rover: reads inputs and return a rover. // Legacy solution
		
# MarsRoverLegacy
		
    This is the intern main class but with a little refactor. 
    It displays instructions and execute the inputs. Intern did a good job but I want to talk with him/her about OOP,
    abstraction, do whiles, SOLID, testing (unit & TDD) and a couple more of clean code practices. We can (should) do
    some katas, it would be nice 🤓😬.

# MarsRover

    This is my solution to problem. 
    It reads the arguments and launch the rover, just follow the instructions and press enter.
   
# ⛏🏃 To build and run

1. You need java 11 and maven installed.

2. You need to do an install and then you run the java class, just open the folder in terminal and:

    > mvn install
    
3. Then you have a target folder with classes, you must move to:

    > cd target/classes/
        
4. After you moved to the package and if you want to try my solution:

    > java MarsRover 
        
5. Or you can try the legacy:

    > java MarsRoverLegacy

6. Also, to run all test, execute in a terminal:

    > mvn test

7. And to run the example test, execute in a terminal:

    > mvn -Dtest=AcceptationTest#shouldReturnExpectedWhenEverythingIsOk test

That's all.
Thanks,
D 
