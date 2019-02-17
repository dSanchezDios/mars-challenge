package mars.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Arrays.asList;
import static mars.model.Instruction.b;
import static mars.model.Instruction.f;
import static mars.model.Orientation.N;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FailWhenObstaclesTest {

	@Test
	void shouldFailWhenThereIsAnObstacleMovingForward() {
		final var instructionList = asList(f, f, f, f);
		final HashSet<Dimension> obstacles = new HashSet<>();
		obstacles.add(new Dimension(new Coordinate(0), new Coordinate(2)));
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(6)), obstacles);
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, instructionList, position);

		assertThrows(IllegalArgumentException.class, rover::executeInstructions);
	}

	@Test
	void shouldFailWhenThereIsAnObstacleMovingBackward() {
		final var instructionList = asList(b, b, b, b);
		final HashSet<Dimension> obstacles = new HashSet<>();
		obstacles.add(new Dimension(new Coordinate(0), new Coordinate(3)));
		final var map = new Map(new Dimension(new Coordinate(5), new Coordinate(3)), obstacles);
		final var position = new Position(new Dimension(new Coordinate(0), new Coordinate(0)), N);
		final var rover = new Rover(map, instructionList, position);

		assertThrows(IllegalArgumentException.class, rover::executeInstructions);
	}
}
