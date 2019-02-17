import mars.RoverUtils;

import java.util.Scanner;

public class MarsRover {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert map size: ex \"5 6\"");
		String map = reader.nextLine();

		System.out.println("Insert rover position: ex \"0 0 N\"");
		String rover = reader.nextLine();

		//TODO get obstacles

		System.out.println("Instructions forward, b = backward, l = turn left, r = turn right):");
		System.out.println("Insert list of instructions: (ex: lbrf)");
		String instructions = reader.nextLine();

		printInputs(map, rover, instructions);

		System.out.println(RoverUtils.launch(map, null, instructions, rover));
	}

	private static void printInputs(String map, String rover, String instructionsNumber) {
		System.out.println("Inputs:");
		System.out.println("Map:");
		System.out.println(map);
		System.out.println("Rover:");
		System.out.println(rover);
		System.out.println("Instructions:");
		System.out.println(instructionsNumber);
	}

}
