package mars.parsers;

import mars.model.Coordinate;
import mars.model.Dimension;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ObstaclesParserTest {

	private final DimensionParser dimensionParser = mock(DimensionParser.class);
	private final ObstaclesParser obstaclesParser = new ObstaclesParser(dimensionParser);

	@Test
	void shouldReturnWhenInputIsNull() {
		final var expected = new HashSet<>();
		final var actual = obstaclesParser.parse(null);
		assertEquals(expected, actual);
	}

	@Test
	void shouldFailWhenInputIsEmpty() {
		final var expected = new HashSet<>();
		final var actual = obstaclesParser.parse("");
		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnPlateauObjectForValidInput() {
		final var input = "5 1-3 4";

		whenDimensionThenReturn("5 1");
		whenDimensionThenReturn("3 4");

		final HashSet<Dimension> expected = new HashSet<>();
		expected.add(dimensionParser.parse("5 1"));
		expected.add(dimensionParser.parse("3 4"));

		final var actual = obstaclesParser.parse(input);

		assertEquals(expected, actual);
	}

	private void whenDimensionThenReturn(String dim) {
		var dimension = new Dimension(
				new Coordinate(valueOf(dim.split(" ")[0])),
				new Coordinate(valueOf(dim.split(" ")[1])));
		when(dimensionParser.parse(dim)).thenReturn(dimension);
	}
}
