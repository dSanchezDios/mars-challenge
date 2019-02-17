I've applied SOLID principles and TDD for develop the project, so this file is my decisions explanation that 
I wrote before start to code:

Instructions for compile, test and run:

		1.- You need java 11 and maven installed.
		
        2.- You need to do an install and then you run the java class, just open the folder in terminal and:
            
            > mvn install
            > cd target/classes/
            > java MarsRover
            
		3.- To run all test, execute in a terminal:
		
			> mvn test
			
		4.- To run the example test, execute in a terminal:
		
			> mvn -Dtest=AcceptationTest#shouldReturnExpectedWhenEverythingIsOk test
		

I have assumed that:

		1.- Rovers and obstacles can not exist out of the map, that means an input with a rover out of
		    the range will throw an IllegalArgumentException with a description.

		2.- Lowerleft coordinates are (0, 0), so there is no negative coordinates, that
		    means an input with negative coordinates will throw an IllegalArgumentException.

		3.- Rover has a position and a list of instructions, that means an input without position
		    will throw an IllegalArgumentException.

		4.- With a plateau coordinates (X, Y), rover movements are not delimited,
		    that means rover position (X+1, Y) will be (0,Y) and (X, Y+1) will be (X, 0) and same for (-1, Y)
		    or (X, -1).
		    
			e.g.:
				- Map range:          (2, 3)
				- Obstacles empty.
			    - Rover position:     (1, 2, N)
			    - Rover instruction:  (f, f)
			    - Rover position after execute instructions: (1, 0, N)

		5.- I do not want the rover to run out of battery 🤖, that means between f's or b's:
		
		    5.1.- Turns in the same direction are optimized in groups of four. 

			e.g.:
			    - x8 r -> x0 r
			    - x9 r -> x1 r
			    - x10 r -> x2 r
			    - x11 r -> x3 r
			
		   5.2.- r and l are opposite.

			e.g.:
			    - rlrlr -> R
			    - lllllllrr -> L

Design:

	With these assumptions I've written tests, main (AcceptationTest) who tests from beginning to end then
	project, the rest of them are the ones that I, using TDD, have implemented the rest of classes.

	    I started doing test for parse the input, they they were "telling" me the objects I needed.

 		# parsers: they parse string input and return new objects or throw exceptions.

          	- RoverParser: it read the global input and calls the rest of parsers, if everything is OK
				it will return the object Rover that contains the list of instructions, position and map.

		# model:

		- Coordinate: an immutable object with a number > 0, they can grow or decrement and be higher than
			other coordinate (methods return a new object).

		- Dimension: an immutable pair of coordinates, a dimension can increment and decrement its variables
		    and tell if is out of a range.

		- Instruction: enum with the three different types, l, r, f, b.

		- Orientation: enum with the four cardinals, each orientation has a right and a left.

		- Map: an immutable object with two variables: dimension, Dimension object for tell rover which is
		    the limit, and obstacles list, a hashSet (it cant be two obstacles in the same square).

        - Position: an immutable group composed of a Diension (X, Y coordinates) and one Orientation.

		- Rover: Main object, an object with a position, map and a list of instructions. 
		     Rovers can execute instructions list, this method execute instruction by instruction from the list
		     and move, or turn depending of the instruction, at the end it return the actual position.
		     Rovers also can execute a single instruction as in the example.
		     I decided just read instructions and put movements private I thought is easier for the user :-).

		# utils: utils class for optimize the list of instructions
		
		RoversUtils:

		- launch: reads inputs and return the result of execute the rover as a String.
		- create rover: reads inputs and return a rover.
		// I dont really like it but I decided implement this function because the intern legacy
		
		MarsRover:
		
		- This is the intern main but with a little refactor. It display instructions and execute the inputs.
		  Intern did a good job but I want to talk with him/her about abstraction, Scanners, do whiles, SOLID,
		  unit testing, TDD and rest of clean code practices 🤓😬.

Thanks,
D.
