import mars.model.Instruction;
import mars.model.Position;

import java.util.Scanner;

import static mars.RoverUtils.createRover;
import static mars.RoverUtils.launch;

public class MarsRover {
	private static final String ARRAY_MODE = "-a";
	private static final String INTERACTIVE_MODE = "-i";
	private static final IllegalArgumentException WRONG_MODE =
			new IllegalArgumentException("Execute in array mode with -a or interactive mode with -i.");

	public static void main(String[] args) {
		checkArguments(args);

		final var mode = args[0];
		final var mapInput = getMapInput();
		final var positionInput = getRoverPositionInput();
		final var obstaclesInput = getObstaclesInput();

		if (mode.equals(ARRAY_MODE)) {
			final var instructionsInput = getInstructionsInput();
			arrayMode(mapInput, obstaclesInput, instructionsInput, positionInput);
		} else if (mode.equals(INTERACTIVE_MODE)) {
			interactiveMode(mapInput, obstaclesInput, positionInput);
		} else {
			throw WRONG_MODE;
		}
	}

	private static void arrayMode(String map, String obstacles, String instructions, String rover) {
		printInputs(map, rover, instructions);
		System.out.println("Rover output:");
		System.out.println(launch(map, obstacles, instructions, rover));
	}

	private static void interactiveMode(String mapInput, String obstaclesInput, String roverInput) {
		printInstructions();
		final var rover = createRover(mapInput, obstaclesInput, null, roverInput);
		final var scanner = new Scanner(System.in);
		var instruction = scanner.nextLine();
		printRoverPosition(rover.executeInstructions(Instruction.valueOf(instruction)));

		do {
			printInstructions();
			printRoverPosition(rover.executeInstructions(Instruction.valueOf(instruction)));
			instruction = scanner.nextLine();
		} while (!instruction.equals("X"));
	}

	private static void checkArguments(String[] args) {
		if (args == null || args.length != 1 || !(args[0].equals(ARRAY_MODE) || args[0].equals(INTERACTIVE_MODE))) {
			throw WRONG_MODE;
		}
	}

	private static void printInstructions() {
		System.out.println("Introduce an instruction: f move forward, b move backward, r right or l left.");
		System.out.println("Press X to exit.");
	}

	private static void printRoverPosition(Position position) {
		System.out.println("Rover position: " + position);
	}


	private static String getRoverPositionInput() {
		System.out.println("Insert rover position ex \"0 0 N\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getMapInput() {
		System.out.println("Insert map size ex \"5 6\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getObstaclesInput() {
		System.out.println("Insert obstacles ex \"1 2-3 4\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getInstructionsInput() {
		System.out.println("Insert list of instructions ex: \"lbrf\"");
		System.out.println("Actions permitted f = forward, b = backward, l = turn left, r = turn right)");
		return new Scanner(System.in).nextLine();
	}

	private static void printInputs(String map, String rover, String instructionsNumber) {
		System.out.println("####################################");
		System.out.println("Inputs:");
		System.out.println("Map: " + map);
		System.out.println("Rover: " + rover);
		System.out.println("Instructions: " + instructionsNumber);
		System.out.println("####################################");
	}

}
