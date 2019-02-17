package mars.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Collections.singletonList;
import static mars.model.Instruction.r;
import static mars.model.Instruction.l;
import static mars.model.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverTurnsTest {

	@Test
	void shouldReturnExpectedPositionWhenTurnToRightNorth() {
		final var instructionList = singletonList(r);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToLeftNorth() {
		final var instructionList = singletonList(l);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), W);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToRightSouth() {
		final var instructionList = singletonList(r);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), S);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), W);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToLeftSouth() {
		final var instructionList = singletonList(l);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), S);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToRightEast() {
		final var instructionList = singletonList(r);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), S);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToLeftEast() {
		final var instructionList = singletonList(l);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), E);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToRightWest() {
		final var instructionList = singletonList(r);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), W);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedPositionWhenTurnToLeftWest() {
		final var instructionList = singletonList(l);
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), new HashSet<>());
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), W);
		final var rover = new Rover(map, instructionList, position);

		final var expected = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), S);
		final var actual = rover.executeInstructions();

		assertEquals(expected, actual);
	}
}
