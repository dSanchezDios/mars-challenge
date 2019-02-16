package mars.parsers;

import mars.model.Map;

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

		obstacles
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
