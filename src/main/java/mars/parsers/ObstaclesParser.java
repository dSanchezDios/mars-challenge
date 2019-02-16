package mars.parsers;

import mars.model.Dimension;
import mars.model.Obstacles;

import java.util.HashSet;

public class ObstaclesParser {
	private final DimensionParser dimensionParser;

	public ObstaclesParser(DimensionParser dimensionParser) {
		this.dimensionParser = dimensionParser;
	}

	public Obstacles parse(String input) {
		if (input == null || input.isEmpty()) {
			return new Obstacles(new HashSet<>());
		}

		final HashSet<Dimension> dimensionList = new HashSet<>();

		final var list = input.split("\n");

		if (list.length == 0) {
			throw new IllegalArgumentException();
		}

		for (String i : list) {
			dimensionList.add(dimensionParser.parse(i));
		}
		return new Obstacles(dimensionList);
	}
}
