package mars.model;

import java.util.List;
import java.util.Objects;

public class Rover {
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

	Position executeInstructions() {
		for (Instruction instruction : instructions) {
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
		return position;
	}

	private Position moveForward() {
		var orientation = position.getOrientation();

		switch (orientation) {
			case N:
				return new Position(position.getCoordinates().incrementY(map.getLimits()), orientation);
			case S:
				return new Position(position.getCoordinates().decrementY(map.getLimits()), orientation);
			case E:
				return new Position(position.getCoordinates().incrementX(map.getLimits()), orientation);
			case W:
				return new Position(position.getCoordinates().decrementX(map.getLimits()), orientation);
		}

		return position;
	}


	private Position moveBackward() {
		var orientation = position.getOrientation();

		switch (orientation) {
			case N:
				return new Position(position.getCoordinates().decrementY(map.getLimits()), orientation);
			case S:
				return new Position(position.getCoordinates().incrementY(map.getLimits()), orientation);
			case E:
				return new Position(position.getCoordinates().decrementX(map.getLimits()), orientation);
			case W:
				return new Position(position.getCoordinates().incrementX(map.getLimits()), orientation);
		}

		return position;
	}

}
