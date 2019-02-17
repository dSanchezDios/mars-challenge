import mars.RoverUtils;

import java.util.Scanner;

public class MarsRover {

	public static void main(String[] args) {
		var reader = new Scanner(System.in);
		System.out.println("Insert map size: ex \"5 6\"");
		var map = reader.nextLine();

		System.out.println("Insert rover position: ex \"0 0 N\"");
		var rover = reader.nextLine();

		//TODO get obstacles

		System.out.println("Insert list of instructions: ex: \"lbrf\"");
		System.out.println("Instructions forward, b = backward, l = turn left, r = turn right):");
		var instructions = reader.nextLine();

		printInputs(map, rover, instructions);

		System.out.println(RoverUtils.launch(map, null, instructions, rover));
		reader.close();
	}

	private static void printInputs(String map, String rover, String instructionsNumber) {
		System.out.println("Inputs:");
		System.out.println("Map: ");
		System.out.print(map);
		System.out.println("Rover: ");
		System.out.print(rover);
		System.out.println("Instructions: ");
		System.out.print(instructionsNumber);
	}

}
