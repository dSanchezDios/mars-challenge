package mars.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Collections.singletonList;
import static mars.model.Instruction.f;
import static mars.model.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverMoveForwardTest {

	@Test
	void shouldReturnExpectedPositionWhenMoveToNorthNoObstacles() {
		final var instructionList = singletonList(f);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(1)), N);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenMoveToSouthNoObstacles() {
		final var instructionList = singletonList(f);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(1)), S);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), S);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenMoveToEastNoObstacles() {
		final var instructionList = singletonList(f);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(1), new Coordinate(0)), E);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenMoveToWestNoObstacles() {
		final var instructionList = singletonList(f);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(1)), W);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(5), new Coordinate(1)), W);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}
}
