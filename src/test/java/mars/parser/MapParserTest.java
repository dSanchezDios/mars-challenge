package mars.parser;

import mars.model.Coordinate;
import mars.model.Dimension;
import mars.model.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class MapParserTest {

	private final DimensionParser dimensionParser = Mockito.mock(DimensionParser.class);
	private final ObstaclesParser obstaclesParser = Mockito.mock(ObstaclesParser.class);
	private final MapParser mapParser = new MapParser(obstaclesParser, dimensionParser);

	@Test
	void shouldFailWhenObstaclesAreOutOfMap() {
		final var obstaclesInput = "1 1-3 4";
		whenDimensionThenReturn("1 1");
		whenDimensionThenReturn("3 4");
		final HashSet<Dimension> obstaclesSet = new HashSet<>();
		obstaclesSet.add(dimensionParser.parse("1 1"));
		obstaclesSet.add(dimensionParser.parse("3 4"));

		when(obstaclesParser.parse(obstaclesInput)).thenReturn(obstaclesSet);

		final var limitsInput = "1 2";
		whenDimensionThenReturn(limitsInput);

		assertThrows(IllegalArgumentException.class, () -> mapParser.parse(limitsInput, obstaclesInput));

	}

	@Test
	void shouldReturnExpected() {
		final var obstaclesInput = "1 1-3 4";
		whenDimensionThenReturn("1 1");
		whenDimensionThenReturn("3 4");
		final HashSet<Dimension> obstaclesSet = new HashSet<>();
		obstaclesSet.add(dimensionParser.parse("1 1"));
		obstaclesSet.add(dimensionParser.parse("3 4"));

		when(obstaclesParser.parse(obstaclesInput)).thenReturn(obstaclesSet);

		final var limitsInput = "3 5";
		whenDimensionThenReturn(limitsInput);
		final var limits = dimensionParser.parse(limitsInput);

		final var expected = new Map(limits, obstaclesSet);
		final var actual = mapParser.parse(limitsInput, obstaclesInput);

		assertEquals(expected, actual);

	}

	private void whenDimensionThenReturn(String dim) {
		var dimension = new Dimension(
				new Coordinate(valueOf(dim.split(" ")[0])),
				new Coordinate(valueOf(dim.split(" ")[1])));
		when(dimensionParser.parse(dim)).thenReturn(dimension);
	}
}
