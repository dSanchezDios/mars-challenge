package mars;

import org.junit.jupiter.api.Test;

import static mars.RoverUtils.launch;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptationTest {

	@Test
	void shouldReturnExpectedWhenInputIsWithNoObstacles() {
		final var mapSize = "5 5";
		final var instructions = "lflflflff";
		final var position = "1 2 N";

		final var expected = "1 3 N";
		final var actual = launch(mapSize, null, instructions, position);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenInputHasEmptyObstaclesAndOptimize() {
		final var mapSize = "5 10";
		final var instructions = "bbrbbrrrrrbrrbllll";
		final var position = "3 3 E";

		final var expected = "1 5 E";
		final var actual = launch(mapSize, "", instructions, position);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenInputHasNoInstructions() {
		final var mapSize = "5 5";
		final var position = "3 3 E";

		final var expected = "3 3 E";
		final var actual = launch(mapSize, null, "", position);

		assertEquals(expected, actual);
	}

}
