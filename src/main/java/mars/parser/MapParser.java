package mars.parser;

import mars.model.Dimension;
import mars.model.Map;

import java.util.HashSet;

public class MapParser {

	private static final IllegalArgumentException OBSTACLE_OUT_OF_MAP =
			new IllegalArgumentException("At least one of the obstacles is out of the map.");

	private final ObstaclesParser obstaclesParser;
	private final DimensionParser dimensionParser;

	public MapParser(ObstaclesParser obstaclesParser, DimensionParser dimensionParser) {
		this.dimensionParser = dimensionParser;
		this.obstaclesParser = obstaclesParser;
	}

	Map parse(String limitInput, String obstaclesInput) {
		final var obstacles = obstaclesParser.parse(obstaclesInput);
		final var limit = dimensionParser.parse(limitInput);

		checkObstaclesOutOfRange(obstacles, limit);

		return new Map(
				limit,
				obstacles
		);
	}

	private void checkObstaclesOutOfRange(HashSet<Dimension> obstacles, Dimension limit) {
		obstacles
				.stream()
				.filter(obstacle -> obstacle.isOutOf(limit))
				.findAny()
				.ifPresent(s -> {
					throw OBSTACLE_OUT_OF_MAP;
				});
	}
}
