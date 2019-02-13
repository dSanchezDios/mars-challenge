package mars.model;

import mars.parsers.CoordinateParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateParserTest {

	private CoordinateParser coordinateParser = new CoordinateParser();

	@Test
	void shouldFailWithNoNumberInput() {
		final var input = "a";
		assertThrows(IllegalArgumentException.class, () -> coordinateParser.parse(input));
	}

}
