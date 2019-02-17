package mars.model;

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

	public Position getPosition() {
		return position;
	}

	public Position executeInstructions() {
		instructions.forEach(this::executeInstruction);
		return position;
	}

	Position executeInstructions(Instruction instruction) {
		executeInstruction(instruction);
		return position;
	}

	private void executeInstruction(Instruction instruction) {
		switch (instruction) {
			case f:
				position = moveForward();
				break;
			case b:
				position = moveBackward();
				break;
			case r:
				position = new Position(position.getCoordinates(), position.getOrientation().getRight());
				break;
			case l:
				position = new Position(position.getCoordinates(), position.getOrientation().getLeft());
				break;
		}
	}

	private Position moveForward() {
		var orientation = position.getOrientation();
		var nextDimension = position.getCoordinates();

		switch (orientation) {
			case N:
				nextDimension = position.getCoordinates().incrementY(map.getLimits());
				break;
			case S:
				nextDimension = position.getCoordinates().decrementY(map.getLimits());
				break;
			case E:
				nextDimension = position.getCoordinates().incrementX(map.getLimits());
				break;
			case W:
				nextDimension = position.getCoordinates().decrementX(map.getLimits());
				break;
		}

		checkObstacle(nextDimension);

		return new Position(nextDimension, position.getOrientation());
	}


	private Position moveBackward() {
		var orientation = position.getOrientation();
		var nextDimension = position.getCoordinates();

		switch (orientation) {
			case N:
				nextDimension = position.getCoordinates().decrementY(map.getLimits());
				break;
			case S:
				nextDimension = position.getCoordinates().incrementY(map.getLimits());
				break;
			case E:
				nextDimension = position.getCoordinates().decrementX(map.getLimits());
				break;
			case W:
				nextDimension = position.getCoordinates().incrementX(map.getLimits());
				break;
		}

		checkObstacle(nextDimension);

		return new Position(nextDimension, position.getOrientation());
	}

	private void checkObstacle(Dimension nextPosition) {
		if (map.getObstacles().contains(nextPosition)) {
			throw new IllegalArgumentException("Next position is an obstacle, rover stopped at " + position);
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
