package mars.parsers;

import mars.model.Coordinate;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class CoordinateParser {
	Coordinate parse(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		checkIfNumber(input);
		return new Coordinate(valueOf(input));
	}

	private void checkIfNumber(String input) {
		try {
			parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
