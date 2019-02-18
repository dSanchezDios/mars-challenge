package mars;

import mars.model.Rover;
import mars.parsers.*;
import org.jetbrains.annotations.NotNull;

public interface RoverUtils {

	static String launch(String mapSize, String obstacles, String instructions, String position) {
		var rover = createRover(mapSize, obstacles, instructions, position);

		return rover.executeInstructions().toString();
	}

	static Rover createRover(String mapSize, String obstacles, String instructions, String position) {
		final RoverParser roverParser = getRoverParser();

		return roverParser.parse(mapSize, obstacles, instructions, position);
	}

	@NotNull
	private static RoverParser getRoverParser() {
		final var coordinateParser = new CoordinateParser();
		final var dimensionParser = new DimensionParser(coordinateParser);

		return new RoverParser(
				new MapParser(
						new ObstaclesParser(dimensionParser),
						dimensionParser),
				new InstructionsParser(),
				new PositionParser(coordinateParser)
		);
	}
}
