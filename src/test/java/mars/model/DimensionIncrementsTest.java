package mars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimensionIncrementsTest {

	@Test
	void assertExpectedWhenXIncrements() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(10));
		var expected = new Dimension(new Coordinate(1), new Coordinate(0));
		var actual = new Dimension(new Coordinate(0), new Coordinate(0)).incrementX(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenXIncrementsWhenIsOnLimit() {
		var limits = new Dimension(new Coordinate(1), new Coordinate(10));
		var expected = new Dimension(new Coordinate(0), new Coordinate(10));
		var actual = new Dimension(new Coordinate(1), new Coordinate(10)).incrementX(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenYIncrements() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(10));
		var expected = new Dimension(new Coordinate(1), new Coordinate(1));
		var actual = new Dimension(new Coordinate(1), new Coordinate(0)).incrementY(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenYIncrementsWhenIsOnLimit() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(1));
		var expected = new Dimension(new Coordinate(10), new Coordinate(0));
		var actual = new Dimension(new Coordinate(10), new Coordinate(1)).incrementY(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenXDecrements() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(10));
		var expected = new Dimension(new Coordinate(0), new Coordinate(0));
		var actual = new Dimension(new Coordinate(1), new Coordinate(0)).decrementX(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenXDecrementsWhenIsOnLimit() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(10));
		var expected = new Dimension(new Coordinate(10), new Coordinate(10));
		var actual = new Dimension(new Coordinate(0), new Coordinate(10)).decrementX(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenYDecrements() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(10));
		var expected = new Dimension(new Coordinate(1), new Coordinate(0));
		var actual = new Dimension(new Coordinate(1), new Coordinate(1)).decrementY(limits);
		assertEquals(expected, actual);
	}

	@Test
	void assertExpectedWhenYDecrementsWhenIsOnLimit() {
		var limits = new Dimension(new Coordinate(10), new Coordinate(100));
		var expected = new Dimension(new Coordinate(10), new Coordinate(100));
		var actual = new Dimension(new Coordinate(10), new Coordinate(0)).decrementY(limits);
		assertEquals(expected, actual);
	}
}
