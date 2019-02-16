package mars.parsers;

import mars.model.Dimension;
import mars.model.Map;
import mars.model.Position;
import mars.model.Rover;

import java.util.HashSet;

public class RoverParser {

	private final MapParser mapParser;
	private final InstructionsParser instructionsParser;
	private final PositionParser positionParser;

	public RoverParser(MapParser mapParser, InstructionsParser instructionsParser, PositionParser positionParser) {
		this.mapParser = mapParser;
		this.instructionsParser = instructionsParser;
		this.positionParser = positionParser;
	}

	public Rover parse(String mapSize, String obstacles, String instructions, String positionInput) {
		final var map = mapParser.parse(mapSize, obstacles);
		final var position = positionParser.parse(positionInput);

		checkRoverOutOfRange(map, position);

		final var obstaclesList = map.getObstacles();

		checkRoverNotInObstacle(position, obstaclesList);

		return new Rover(
				map,
				instructionsParser.parse(instructions),
				position
		);
	}

	private void checkRoverNotInObstacle(Position position, HashSet<Dimension> obstaclesList) {
		if (obstaclesList.contains(position.getCoordinates())) {
			throw new IllegalArgumentException();
		}
	}

	private void checkRoverOutOfRange(Map map, Position position) {
		if (position.getCoordinates().isOutOf(map.getLimits())) {
			throw new IllegalArgumentException();
		}
	}
}
