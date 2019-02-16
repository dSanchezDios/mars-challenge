package mars;

import mars.parsers.RoverParser;

class RoverLauncher {

	private final RoverParser roverParser;

	RoverLauncher(RoverParser roverParser) {
		this.roverParser = roverParser;
	}

	String launch(String mapSize, String obstacles, String instructions, String position) {
		var rover = roverParser.parse(mapSize, obstacles, instructions, position);

		return rover.executeInstructions().toString();
	}
}
