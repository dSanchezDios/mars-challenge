package mars.parser;

import mars.model.Coordinate;
import mars.model.Dimension;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DimensionParser {

	private static final String SPACE = " ";
	private static final IllegalArgumentException INPUT_EMPTY =
			new IllegalArgumentException("Dimension input is null or empty.");
	private static final IllegalArgumentException INPUT_NOT_TWO_DIMENSION =
			new IllegalArgumentException("Dimension input needs two coordinates.");

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
			throw INPUT_NOT_TWO_DIMENSION;
		}
	}

	private void checkInputNull(String plateauLine) {
		if (plateauLine == null || plateauLine.trim().isEmpty()) {
			throw INPUT_EMPTY;
		}
	}
}