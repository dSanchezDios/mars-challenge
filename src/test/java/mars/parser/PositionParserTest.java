package mars.parser;

import mars.model.Coordinate;
import mars.model.Dimension;
import mars.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static mars.model.Orientation.N;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PositionParserTest {

	private final CoordinateParser coordinateParser = Mockito.mock(CoordinateParser.class);
	private final PositionParser positionParser = new PositionParser(coordinateParser);

	@Test
	void shouldFailWhitNullInput() {
		final String input = null;
		assertThrows(IllegalArgumentException.class, () -> positionParser.parse(input));
	}

	@Test
	void shouldFailWhitEmptyInput() {
		final var input = "";
		assertThrows(IllegalArgumentException.class, () -> positionParser.parse(input));
	}

	@Test
	void shouldFailWhenInputHasNoThreeArguments() {
		final var input = "5 6";
		assertThrows(IllegalArgumentException.class, () -> positionParser.parse(input));
	}

	@Test
	void shouldFailWhenOrientationIsNotValid() {
		final var input = "5 6 J";
		assertThrows(IllegalArgumentException.class, () -> positionParser.parse(input));
	}

	@Test
	void shouldFailWhenInputHasMoreThanThreeArguments() {
		final var input = "5 6 N S";
		assertThrows(IllegalArgumentException.class, () -> positionParser.parse(input));
	}

	@Test
	void shouldReturnExpectedPosition() {
		final var input = "5 6 N";

		final var x = whenCoordinateThenReturn(input.split(" ")[0]);
		final var y = whenCoordinateThenReturn(input.split(" ")[1]);

		final var expected = new Position(new Dimension(x, y), N);

		final var actual = positionParser.parse(input);

		assertEquals(expected, actual);
	}


	private Coordinate whenCoordinateThenReturn(String coordinate) {
		final var x = new Coordinate(Integer.valueOf(coordinate));
		when(coordinateParser.parse(coordinate)).thenReturn(x);
		return x;
	}
}
