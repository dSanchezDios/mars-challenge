package mars.parser;

import mars.model.Coordinate;
import mars.model.Dimension;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DimensionParserTest {

	private final CoordinateParser coordinateParser = Mockito.mock(CoordinateParser.class);
	private final DimensionParser dimensionParser = new DimensionParser(coordinateParser);

	@Test
	void shouldFailWhenInputIsNull() {
		final String input = null;
		assertThrows(IllegalArgumentException.class, () -> dimensionParser.parse(input));
	}

	@Test
	void shouldFailWhenInputIsEmpty() {
		final var input = "";
		assertThrows(IllegalArgumentException.class, () -> dimensionParser.parse(input));
	}

	@Test
	void shouldFailWhenInputHasOneNumber() {
		final var input = "5";
		assertThrows(IllegalArgumentException.class, () -> dimensionParser.parse(input));
	}

	@Test
	void shouldFailWhenInputHasThreeNumbers() {
		final var input = "5 5 5";
		assertThrows(IllegalArgumentException.class, () -> dimensionParser.parse(input));
	}

	@Test
	void shouldReturnPlateauObjectForValidInput() {
		final var input = "5 6";
		final var x = whenCoordinateThenReturn(input.split(" ")[0]);
		final var y = whenCoordinateThenReturn(input.split(" ")[1]);

		final var expected = new Dimension(x, y);
		final var actual = dimensionParser.parse(input);

		assertEquals(expected, actual);
	}

	private Coordinate whenCoordinateThenReturn(String coordinate) {
		final var x = new Coordinate(Integer.valueOf(coordinate));
		when(coordinateParser.parse(coordinate)).thenReturn(x);
		return x;
	}
}
