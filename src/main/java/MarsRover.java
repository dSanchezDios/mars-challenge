import java.util.Scanner;

import static mars.RoverUtils.launch;

public class MarsRover {

	public static void main(String[] args) {

		final var mapInput = getMapInput();
		final var positionInput = getRoverPositionInput();
		final var obstaclesInput = getObstaclesInput();
		final var instructionsInput = getInstructionsInput();

		printInputs(
				mapInput,
				obstaclesInput,
				positionInput,
				instructionsInput
		);

		System.out.println("# Rover output:");
		System.out.println(
				launch(
						mapInput,
						obstaclesInput,
						instructionsInput,
						positionInput)
		);
		System.out.println("# Good bye.");

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

	private static String getInstructionsInput() {
		System.out.println("# Insert list of instructions e.g.: \"lbrf\"");
		System.out.println("# Actions permitted f = forward, b = backward, l = turn left, r = turn right)");
		return new Scanner(System.in).nextLine();
	}

	private static void printInputs(String map, String obstacles, String instructions, String position) {
		System.out.println("###########  Inputs  ################");
		System.out.println("# Map size: " + map);
		System.out.println("# Obstacles list: " + obstacles);
		System.out.println("# Rover's position: " + position);
		System.out.println("# Instructions : " + instructions);
		System.out.println("####################################");
	}
}
