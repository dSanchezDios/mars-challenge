package mars;

import mars.model.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Collections.emptyList;
import static mars.RoverUtils.createRover;
import static mars.RoverUtils.launch;
import static mars.model.Instruction.*;
import static mars.model.Orientation.*;
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

	@Test
	void shouldReturnRover() {
		final var mapSize = "5 5";
		final var position = "3 3 E";

		final var actual = createRover(mapSize, null, "", position);

		final var expected =
				new Rover(
						new Map(new Dimension(new Coordinate(5), new Coordinate(5)), new HashSet<>()),
						emptyList(),
						new Position(new Dimension(new Coordinate(3), new Coordinate(3)), E)
				);

		assertEquals(expected, actual);
	}

	@Test
	void shouldRoverMoveForward() {
		final var mapSize = "5 5";
		final var position = "3 3 E";

		final var rover = createRover(mapSize, null, "", position);

		final var expected = new Position(new Dimension(new Coordinate(4), new Coordinate(3)), E);
		final var actual = rover.executeInstructions(f);

		assertEquals(expected, actual);
	}

	@Test
	void shouldRoverMoveBackward() {
		final var mapSize = "5 5";
		final var position = "0 0 E";

		final var rover = createRover(mapSize, null, "", position);

		final var expected = new Position(new Dimension(new Coordinate(5), new Coordinate(0)), E);
		final var actual = rover.executeInstructions(b);

		assertEquals(expected, actual);
	}

	@Test
	void shouldRoverTurn() {
		final var mapSize = "5 5";
		final var position = "3 3 E";

		final var rover = createRover(mapSize, null, "", position);

		final var expected = new Position(new Dimension(new Coordinate(3), new Coordinate(3)), S);
		final var actual = rover.executeInstructions(r);

		assertEquals(expected, actual);
	}

	@Test
	void shouldRoverTurnLeft() {
		final var mapSize = "5 5";
		final var position = "3 3 E";

		final var rover = createRover(mapSize, null, "", position);

		final var expected = new Position(new Dimension(new Coordinate(3), new Coordinate(3)), N);
		final var actual = rover.executeInstructions(l);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenEverythingIsOk() {
		final var mapSize = "50 10";
		final var instructions = "bbrbbrrrrrbrrbllll";
		final var position = "3 3 E";
		final var obstacles = "4 5-30 10";

		final var expected = "1 5 E";
		final var actual = launch(mapSize, obstacles, instructions, position);

		assertEquals(expected, actual);
	}
}
