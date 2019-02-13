package mars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovementsTest {

	@Test
	void shouldReturnExpectedWhenCoordinateCanGrow() {
		final var expected = new Coordinate(2);

		final var actual = new Coordinate(1).increment();

		assertEquals(expected, actual);
	}
}
