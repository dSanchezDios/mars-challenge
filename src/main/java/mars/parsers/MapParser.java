package mars.parsers;

import mars.model.Dimension;
import mars.model.Map;

import java.util.HashSet;

class MapParser {
	private final ObstaclesParser obstaclesParser;
	private final DimensionParser dimensionParser;

	MapParser(ObstaclesParser obstaclesParser, DimensionParser dimensionParser) {
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
					throw new IllegalArgumentException();
				});
	}
}
