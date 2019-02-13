package mars.parsers;

import mars.model.Coordinate;

import static java.lang.Integer.valueOf;

class CoordinateParser {
	Coordinate parse(String input) {
		return new Coordinate(valueOf(input));
	}
}
