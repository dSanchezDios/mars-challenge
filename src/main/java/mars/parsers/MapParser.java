package mars.parsers;

import mars.model.Dimension;
import mars.model.Map;
import mars.model.Obstacles;

class MapParser {
	private final ObstaclesParser obstaclesParser;
	private final DimensionParser dimensionParser;

	MapParser(ObstaclesParser obstaclesParser, DimensionParser dimensionParser) {
		this.dimensionParser = dimensionParser;
		this.obstaclesParser = obstaclesParser;
	}

	Map parse(String limitInput, String obstaclesInput) {
		final Obstacles obstacles = obstaclesParser.parse(obstaclesInput);
		final Dimension limit = dimensionParser.parse(limitInput);

		obstacles.getObstaclesList()
				.stream()
				.filter(obstacle -> obstacle.isOutOf(limit))
				.findAny()
				.ifPresent(s -> {
					throw new IllegalArgumentException();
				});

		return new Map(
				limit,
				obstacles
		);
	}
}
