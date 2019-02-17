package mars.parsers;

import mars.model.Dimension;

import java.util.HashSet;

public class ObstaclesParser {

	private static final String LINE_BREAK = "\n";
	private static final IllegalArgumentException OBSTACLES_INPUT_HAS_NO_SEPARATOR =
			new IllegalArgumentException("Obstacles input has no separator.");

	private final DimensionParser dimensionParser;

	public ObstaclesParser(DimensionParser dimensionParser) {
		this.dimensionParser = dimensionParser;
	}

	public HashSet<Dimension> parse(String input) {
		final HashSet<Dimension> obstaclesList = new HashSet<>();

		if (input == null || input.trim().isEmpty()) {
			return obstaclesList;
		}

		final var list = input.split(LINE_BREAK);

		if (list.length == 0) {
			throw OBSTACLES_INPUT_HAS_NO_SEPARATOR;
		}

		for (String i : list) {
			obstaclesList.add(dimensionParser.parse(i));
		}

		return obstaclesList;
	}
}
