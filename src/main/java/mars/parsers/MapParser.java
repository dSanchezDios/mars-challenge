package mars.parsers;

import mars.model.Dimension;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class MapParser {
	private static final String SPACE = " ";

	private final CoordinateParser coordinateParser;

	public MapParser(CoordinateParser coordinateParser) {
		this.coordinateParser = coordinateParser;
	}

	Dimension parse(String plateauLine) {
		if (plateauLine == null || plateauLine.isEmpty()) {
			throw new IllegalArgumentException();
		}

		var coordinates = stream(plateauLine.split(SPACE)).map(coordinateParser::parse).collect(toList());

		if (coordinates.size() != 2) {
			throw new IllegalArgumentException();
		}

		return new Dimension(coordinates.get(0), coordinates.get(1));
	}
}