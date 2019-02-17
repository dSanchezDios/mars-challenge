package mars;

import mars.parsers.*;

public final class RoverUtils {

	public static String launch(String mapSize, String obstacles, String instructions, String position) {
		final var coordinateParser = new CoordinateParser();
		final var dimensionParser = new DimensionParser(coordinateParser);

		final RoverParser roverParser = new RoverParser(
				new MapParser(new ObstaclesParser(dimensionParser), dimensionParser),
				new InstructionsParser(),
				new PositionParser(coordinateParser)
		);

		var rover = roverParser.parse(mapSize, obstacles, instructions, position);

		return rover.executeInstructions().toString();
	}
}
