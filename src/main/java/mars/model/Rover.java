package mars.model;

import java.util.List;
import java.util.Objects;

public class Rover {
	private final Map map;
	private final List<Instruction> instructions;
	private final Position position;

	public Rover(Map map, List<Instruction> instructions, Position position) {
		this.map = map;
		this.instructions = instructions;
		this.position = position;
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
