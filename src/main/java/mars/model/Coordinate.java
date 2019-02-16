package mars.model;

import java.util.Objects;

public class Coordinate {
	private final int value;

	public Coordinate(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordinate that = (Coordinate) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	Coordinate increment(Coordinate limit) {
		if (value < limit.value) {
			return new Coordinate(value + 1);
		}
		return new Coordinate(0);
	}

	Coordinate decrement(Coordinate limit) {
		if (value > 0) {
			return new Coordinate(value - 1);
		}
		return limit;
	}

	boolean isBigger(Coordinate input) {
		return value > input.value;
	}
}
