package mars.parsers;

import mars.model.Coordinate;

import static java.lang.Integer.valueOf;

public class CoordinateParser {
	public Coordinate parse(String input) {
		return new Coordinate(valueOf(input));
	}
}
