package mars.parsers;

import mars.model.Dimension;
import mars.model.Orientation;
import mars.model.Position;

import java.util.List;

import static java.util.Arrays.asList;

public class PositionParser {
	private static final String SPACE = " ";
	private final CoordinateParser coordinateParser;

	public PositionParser(CoordinateParser coordinateParser) {
		this.coordinateParser = coordinateParser;
	}

	Position parse(String input) {
		checkInputNull(input);

		var parts = asList(input.split(SPACE));

		checkInputWellFormed(parts);

		return new Position(new Dimension(
				coordinateParser.parse(parts.get(0)),
				coordinateParser.parse(parts.get(1))),
				Orientation.valueOf(parts.get(2))
		);
	}

	private void checkInputNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
	}

	private void checkInputWellFormed(List<String> parts) {
		if (parts.size() != 3) {
			throw new IllegalArgumentException();
		}
	}
}
