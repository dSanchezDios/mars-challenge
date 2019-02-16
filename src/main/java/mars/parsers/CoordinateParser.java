package mars.parsers;

import mars.model.Coordinate;

import static java.lang.Integer.parseInt;

public class CoordinateParser {
	Coordinate parse(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		try {
			return new Coordinate(parseInt(input));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
