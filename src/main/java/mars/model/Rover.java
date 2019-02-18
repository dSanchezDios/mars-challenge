package mars.model;

import mars.exception.RoveFoundObstacleException;

import java.util.List;
import java.util.Objects;

public final class Rover {
	private final Map map;
	private final List<Instruction> instructions;
	private Position position;

	public Rover(Map map, List<Instruction> instructions, Position position) {
		this.map = map;
		this.instructions = instructions;
		this.position = position;
	}

	public Position executeInstructions() {
		instructions.forEach(this::executeInstruction);
		return position;
	}

	public Position executeInstructions(Instruction instruction) {
		executeInstruction(instruction);
		return position;
	}

	private void executeInstruction(Instruction instruction) {
		switch (instruction) {
			case f:
				position = new Position(moveForward(), position.getOrientation());
				break;
			case b:
				position = new Position(moveBackward(), position.getOrientation());
				break;
			case r:
				position = new Position(position.getDimension(), position.getOrientation().getRight());
				break;
			case l:
				position = new Position(position.getDimension(), position.getOrientation().getLeft());
				break;
		}
	}

	private Dimension moveForward() {
		var nextDimension = position.getDimension();

		switch (position.getOrientation()) {
			case N:
				nextDimension = position.getDimension().incrementY(map.getLimits());
				break;
			case S:
				nextDimension = position.getDimension().decrementY(map.getLimits());
				break;
			case E:
				nextDimension = position.getDimension().incrementX(map.getLimits());
				break;
			case W:
				nextDimension = position.getDimension().decrementX(map.getLimits());
				break;
		}

		checkObstacle(nextDimension);

		return nextDimension;
	}

	private Dimension moveBackward() {
		var nextDimension = position.getDimension();

		switch (position.getOrientation()) {
			case N:
				nextDimension = position.getDimension().decrementY(map.getLimits());
				break;
			case S:
				nextDimension = position.getDimension().incrementY(map.getLimits());
				break;
			case E:
				nextDimension = position.getDimension().decrementX(map.getLimits());
				break;
			case W:
				nextDimension = position.getDimension().incrementX(map.getLimits());
				break;
		}

		checkObstacle(nextDimension);

		return nextDimension;
	}

	private void checkObstacle(Dimension nextPosition) {
		if (map.getObstacles().contains(nextPosition)) {
			throw new RoveFoundObstacleException(position);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rover rover = (Rover) o;
		return map.equals(rover.map) &&
				instructions.equals(rover.instructions) &&
				position.equals(rover.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(map, instructions, position);
	}
}
