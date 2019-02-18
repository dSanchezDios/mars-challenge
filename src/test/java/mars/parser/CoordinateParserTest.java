package mars.parser;

import mars.exception.CoordinateException;
import mars.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateParserTest {

	private CoordinateParser coordinateParser = new CoordinateParser();

	@Test
	void shouldFailWithNull() {
		assertThrows(IllegalArgumentException.class, () -> coordinateParser.parse(null));
	}

	@Test
	void shouldFailEmpty() {
		assertThrows(IllegalArgumentException.class, () -> coordinateParser.parse(""));
	}

	@Test
	void shouldFailEmptyTrim() {
		assertThrows(IllegalArgumentException.class, () -> coordinateParser.parse("  "));
	}

	@Test
	void shouldFailWithNoNumberInput() {
		final var input = "a";
		assertThrows(IllegalArgumentException.class, () -> coordinateParser.parse(input));
	}

	@Test
	void shouldFailWithNumberNegativeInInput() {
		final var input = "-1";
		assertThrows(CoordinateException.class, () -> coordinateParser.parse(input));
	}

	@Test
	void shouldReturnCoordinateValid() {
		final var input = "1";
		final var expected = new Coordinate(1);

		final var actual = coordinateParser.parse(input);

		assertEquals(expected, actual);
	}
}
