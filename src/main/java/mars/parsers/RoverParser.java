package mars.parsers;

import mars.model.Rover;

class RoverParser {

	private final MapParser mapParser;
	private final InstructionsParser instructionsParser;
	private final PositionParser positionParser;

	RoverParser(MapParser mapParser, InstructionsParser instructionsParser, PositionParser positionParser) {
		this.mapParser = mapParser;
		this.instructionsParser = instructionsParser;
		this.positionParser = positionParser;
	}

	Rover parse(String mapSize, String obstacles, String instructions, String positionInput) {
		final var map = mapParser.parse(mapSize, obstacles);
		final var position = positionParser.parse(positionInput);

		if (position.getCoordinates().isOutOf(map.getLimits())) {
			throw new IllegalArgumentException();
		}

		final var obstaclesList = map.getObstacles();

		if (obstaclesList.contains(position.getCoordinates())) {
			throw new IllegalArgumentException();
		}

		return new Rover(
				map,
				instructionsParser.parse(instructions),
				position
		);
	}
}
