package mars;

import mars.model.Instruction;
import mars.model.Rover;
import org.junit.jupiter.api.Test;

import static mars.RoverUtils.createRover;
import static mars.RoverUtils.launch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputsExceptionsEndToEndTest {

	@Test
	void shouldFailWhenCoordinateNegativeInMap() {
		final var mapSize = "-1 1";
		final var instructions = "lflflflff";
		final var position = "1 0 N";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenCoordinateNegativeInRover() {
		final var mapSize = "5 10";
		final var instructions = "lflflflff";
		final var position = "3 -3 E";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenWrongOrientationInRover() {
		final var mapSize = "5 10";
		final var instructions = "lflflflff";
		final var position = "3 3 WS";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenObstaclesInputIsWrong() {
		final var mapSize = "5 5";
		final var position = "1 1 N";
		final var obstacles = "1 23 5";

		assertThrows(IllegalArgumentException.class, () -> createRover(mapSize, obstacles, null, position));
	}

	@Test
	void shouldFailWhenRoverIsOutOfMap() {
		final var mapSize = "1 1";
		final var instructions = "lflflflff";
		final var position = "1 2 N";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenInstructionIllegal() {
		final var mapSize = "5 10";
		final var instructions = "lrfbt";
		final var position = "3 3 E";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenObstacleOutOfMap() {
		final var mapSize = "5 5";
		final var position = "3 3 E";
		final var instructions = "lrfb";
		final var obstacles = "1 2-3 6";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, obstacles, instructions, position));
	}

	@Test
	void shouldFailWhenRoverIsInAObstacle() {
		final var mapSize = "5 5";
		final var position = "1 2 E";
		final var instructions = "lrfb";
		final var obstacles = "1 2-3 5";

		assertThrows(IllegalArgumentException.class, () -> launch(mapSize, obstacles, instructions, position));
	}

	@Test
	void shouldFailWhenRoverIsOutOfMapCreate() {
		final var mapSize = "1 1";
		final var instructions = "lflflflff";
		final var position = "1 2 N";

		assertThrows(IllegalArgumentException.class, () -> createRover(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenInstructionIllegalCreate() {
		final var mapSize = "5 10";
		final var instructions = "lrfbt";
		final var position = "3 3 E";

		assertThrows(IllegalArgumentException.class, () -> createRover(mapSize, null, instructions, position));
	}

	@Test
	void shouldFailWhenObstacleOutOfMapCreate() {
		final var mapSize = "5 5";
		final var position = "3 3 E";
		final var instructions = "lrfb";
		final var obstacles = "1 2-3 6";

		assertThrows(IllegalArgumentException.class, () -> createRover(mapSize, obstacles, instructions, position));
	}

	@Test
	void shouldFailWhenRoverIsInAObstacleCreate() {
		final var mapSize = "5 5";
		final var position = "1 2 E";
		final var instructions = "lrfb";
		final var obstacles = "1 2-3 5";

		assertThrows(IllegalArgumentException.class, () -> createRover(mapSize, obstacles, instructions, position));
	}

	@Test
	void shouldFailWhenRoverMoveForwardToAnObstacle() {
		final var mapSize = "5 5";
		final var position = "1 1 N";
		final var obstacles = "1 2-3 5";
		final Rover rover = createRover(mapSize, obstacles, null, position);

		assertThrows(IllegalArgumentException.class, () -> rover.executeInstructions(Instruction.f));
	}

	@Test
	void shouldFailWhenRoverMoveBackwardToAnObstacle() {
		final var mapSize = "5 5";
		final var position = "1 2 N";
		final var obstacles = "1 1-3 5";
		final Rover rover = createRover(mapSize, obstacles, null, position);

		assertThrows(IllegalArgumentException.class, () -> rover.executeInstructions(Instruction.b));
	}
}
