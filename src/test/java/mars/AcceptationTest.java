package mars;

import mars.parsers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptationTest {

	@Test
	void shouldReturnExpectedWhenInputIsWithNoObstacles() {
		final var coordinateParser = new CoordinateParser();

		final DimensionParser dimensionParser = new DimensionParser(
				coordinateParser
		);

		final RoverParser roverParser = new RoverParser(
				new MapParser(new ObstaclesParser(dimensionParser), dimensionParser),
				new InstructionsParser(),
				new PositionParser(coordinateParser));
		final var launcher = new RoverLauncher(
				roverParser
		);

		final var mapSize = "5 5";
		final var instructions = "lflflflff";
		final var position = "1 2 N";

		final var expected = "1 3 N";
		final var actual = launcher.launch(mapSize, null, instructions, position);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenInputHasEmptyObstaclesAndOptimize() {
		final var coordinateParser = new CoordinateParser();

		final DimensionParser dimensionParser = new DimensionParser(
				coordinateParser
		);

		final RoverParser roverParser = new RoverParser(
				new MapParser(new ObstaclesParser(dimensionParser), dimensionParser),
				new InstructionsParser(),
				new PositionParser(coordinateParser));
		final var launcher = new RoverLauncher(
				roverParser
		);

		final var mapSize = "5 5";
		final var instructions = "bbrbbrrrrrbrrbllll";
		final var position = "3 3 E";

		final var expected = "1 5 E";
		final var actual = launcher.launch(mapSize, "", instructions, position);

		assertEquals(expected, actual);
	}

}
