package mars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoordinateComparatorTests {

	@Test
	void shouldReturnTrueWhenObjectIsBiggerThanInput() {
		final var coordinate = new Coordinate(4);
		final var input = new Coordinate(2);
		assertTrue(coordinate.isBigger(input));
	}

	@Test
	void shouldReturnFalseWhenObjectIsEqualsThanInput() {
		final var coordinate = new Coordinate(2);
		final var input = new Coordinate(2);
		assertFalse(coordinate.isBigger(input));
	}

	@Test
	void shouldReturnFalseWhenObjectIsSmallerThanInput() {
		final var coordinate = new Coordinate(2);
		final var input = new Coordinate(5);
		assertFalse(coordinate.isBigger(input));
	}
}
