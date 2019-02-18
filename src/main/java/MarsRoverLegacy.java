import mars.model.Instruction;
import mars.model.Position;

import java.util.Scanner;

import static mars.RoverUtils.createRover;

public class MarsRoverLegacy {

	public static void main(String[] args) {

		final var mapInput = getMapInput();
		final var positionInput = getRoverPositionInput();
		final var obstaclesInput = getObstaclesInput();

		interactiveMode(
				mapInput,
				obstaclesInput,
				positionInput
		);
	}

	private static void interactiveMode(String mapInput, String obstaclesInput, String roverInput) {
		final var rover = createRover(mapInput, obstaclesInput, null, roverInput);
		final var scanner = new Scanner(System.in);

		printInputs(mapInput, obstaclesInput, roverInput);
		printInstructions();
		var instruction = scanner.nextLine();

		do {
			printInstructions();
			printRoverPosition(rover.executeInstructions(Instruction.valueOf(instruction)));
			instruction = scanner.nextLine();
		} while (!instruction.equals("X") && isAInstructionValid(instruction));

		printGoodBye();
	}

	private static void printGoodBye() {
		System.out.println("# You've pressed X or a non instruction valid.");
		System.out.println("# Good bye.");
	}

	private static boolean isAInstructionValid(String instruction) {
		try {
			Instruction.valueOf(instruction);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	private static void printInstructions() {
		System.out.println("# Introduce an instruction: f move forward, b move backward, r right or l left.");
		System.out.println("# Enter X to exit.");
	}

	private static void printRoverPosition(Position position) {
		System.out.println("Rover position: " + position);
	}


	private static String getRoverPositionInput() {
		System.out.println("# Insert rover position e.g. \"0 0 N\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getMapInput() {
		System.out.println("# Insert map size e.g. \"5 6\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getObstaclesInput() {
		System.out.println("# Insert obstacles e.g. \"1 2-3 4\"");
		return new Scanner(System.in).nextLine();
	}

	private static void printInputs(String map, String obstacles, String roverPosition) {
		System.out.println("####################################");
		System.out.println("# Inputs:");
		System.out.println("# Map: " + map);
		System.out.println("# Obstacles: " + obstacles);
		System.out.println("# Rover Position: " + roverPosition);
		System.out.println("####################################");
	}
}
