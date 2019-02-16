package mars.parsers;

import mars.model.Map;

public class MapParser {
	private final ObstaclesParser obstaclesParser;
	private final DimensionParser dimensionParser;

	public MapParser(ObstaclesParser obstaclesParser, DimensionParser dimensionParser) {
		this.dimensionParser = dimensionParser;
		this.obstaclesParser = obstaclesParser;
	}

	Map parse(String limit, String obstacles) {
		return new Map(
				dimensionParser.parse(limit),
				obstaclesParser.parse(obstacles)
		);
	}
}
