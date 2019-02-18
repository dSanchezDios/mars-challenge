package mars.parser;

import mars.model.Dimension;
import mars.model.Map;
import mars.model.Position;
import mars.model.Rover;

import java.util.HashSet;

public class RoverParser {

	private static final IllegalArgumentException OUT_OF_MAP = new IllegalArgumentException("Rover is out of map range.");
	private static final IllegalArgumentException IN_A_OBSTACLE = new IllegalArgumentException("Rover is set in a obstacle.");

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

	private void checkRoverOutOfRange(Map map, Position position) {
		if (position.getDimension().isOutOf(map.getLimits())) {
			throw OUT_OF_MAP;
		}
	}

	private void checkRoverNotInObstacle(Position position, HashSet<Dimension> obstaclesList) {
		if (obstaclesList.contains(position.getDimension())) {
			throw IN_A_OBSTACLE;
		}
	}

}
