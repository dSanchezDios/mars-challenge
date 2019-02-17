import mars.RoverUtils;

import java.util.Scanner;

public class MarsRover {

	public static void main(String[] args) {

		var map = getMap();
		var rover = getRoverPosition();
		var obstacles = getObstacles();
		var instructions = getInstructions();

		printInputs(map, rover, instructions);

		System.out.println("Rover log:");
		System.out.println(RoverUtils.launch(map, obstacles, instructions, rover));
	}

	private static String getRoverPosition() {
		System.out.println("Insert rover position ex \"0 0 N\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getMap() {
		System.out.println("Insert map size ex \"5 6\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getObstacles() {
		System.out.println("Insert obstacles ex \"1 2-3 4\"");
		return new Scanner(System.in).nextLine();
	}

	private static String getInstructions() {
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
