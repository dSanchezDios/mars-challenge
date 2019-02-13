package mars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovementsTest {

	@Test
	void shouldReturnExpectedWhenCoordinateCanGrow() {
		final var limit = new Coordinate(3);
		final var expected = new Coordinate(2);

		final var actual = new Coordinate(1).increment(limit);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedZeroWhenCoordinateIsLimit() {
		final var limit = new Coordinate(3);

		final var expected = new Coordinate(0);

		final var actual = new Coordinate(3).increment(limit);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenCoordinateCanNotDecrease() {
		final var expected = new Coordinate(0);

		final var actual = new Coordinate(1).decrement();

		assertEquals(expected, actual);
	}

}
