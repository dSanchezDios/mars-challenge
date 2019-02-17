package mars.parsers;

import mars.model.Coordinate;

import static java.lang.Integer.parseInt;

public class CoordinateParser {

	private static final IllegalArgumentException NOT_A_NUMBER =
			new IllegalArgumentException("Input is not a coordinate valid.");

	Coordinate parse(String input) {
		checkInput(input);

		return new Coordinate(getNumber(input));
	}

	private void checkInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	private int getNumber(String input) {
		try {
			return parseInt(input);
		} catch (NumberFormatException e) {
			throw NOT_A_NUMBER;
		}
	}
}
