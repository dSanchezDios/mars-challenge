package mars.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Collections.emptyList;
import static mars.model.Instruction.*;
import static mars.model.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverSingleInstructionTest {

	@Test
	void shouldReturnExpectedPositionWhenMoveForwardNoObstacles() {
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, emptyList(), position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(1)), N);
		final var actual = rover.executeInstructions(f);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenMoveBackwardNoObstacles() {
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, emptyList(), position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(6)), N);
		final var actual = rover.executeInstructions(b);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnRight() {
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, emptyList(), position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var actual = rover.executeInstructions(r);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnLeft() {
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, emptyList(), position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), W);
		final var actual = rover.executeInstructions(l);

		assertEquals(expected, actual);
	}

}
