package mars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DimensionOutComparatorTest {

	@Test
	void shouldReturnTrueWhenObjectIsBiggerThanInput() {
		final var dimension = new Dimension(
				new Coordinate(5),
				new Coordinate(4)
		);
		final var limit = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);

		assertTrue(dimension.isOutOf(limit));
	}

	@Test
	void shouldReturnTrueWhenObjectIsBiggerThanInputWithY() {
		final var dimension = new Dimension(
				new Coordinate(4),
				new Coordinate(5)
		);
		final var limit = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);

		assertTrue(dimension.isOutOf(limit));
	}

	@Test
	void shouldReturnTrueWhenObjectIsBiggerThanInputWithTwoCoords() {
		final var dimension = new Dimension(
				new Coordinate(5),
				new Coordinate(5)
		);
		final var limit = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);

		assertTrue(dimension.isOutOf(limit));
	}

	@Test
	void shouldReturnFalseWhenObjectIsSameThanInput() {
		final var dimension = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);
		final var limit = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);

		assertFalse(dimension.isOutOf(limit));
	}

	@Test
	void shouldReturnFalseWhenObjectIsSmallerThanInput() {
		final var dimension = new Dimension(
				new Coordinate(4),
				new Coordinate(4)
		);
		final var limit = new Dimension(
				new Coordinate(5),
				new Coordinate(5)
		);

		assertFalse(dimension.isOutOf(limit));
	}

}
