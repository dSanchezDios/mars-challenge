package mars.parsers;

import mars.model.Coordinate;
import mars.model.Dimension;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DimensionParser {
	private static final String SPACE = " ";

	private final CoordinateParser coordinateParser;

	public DimensionParser(CoordinateParser coordinateParser) {
		this.coordinateParser = coordinateParser;
	}

	Dimension parse(String plateauLine) {
		checkInputNull(plateauLine);

		var coordinates = stream(plateauLine.split(SPACE))
				.map(coordinateParser::parse)
				.collect(toList());

		checkInputWellFormed(coordinates);

		return new Dimension(coordinates.get(0), coordinates.get(1));
	}

	private void checkInputWellFormed(List<Coordinate> coordinates) {
		if (coordinates.size() != 2) {
			throw new IllegalArgumentException();
		}
	}

	private void checkInputNull(String plateauLine) {
		if (plateauLine == null || plateauLine.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}