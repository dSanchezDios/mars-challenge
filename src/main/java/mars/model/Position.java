package mars.model;

public final class Position {
	private final Dimension dimension;
	private final Orientation orientation;

	public Position(Dimension dimension, Orientation orientation) {
		this.dimension = dimension;
		this.orientation = orientation;
	}

	public Dimension getDimension() {
		return dimension;
	}

	Orientation getOrientation() {
		return orientation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Position position = (Position) o;

		if (!dimension.equals(position.dimension)) return false;
		return orientation == position.orientation;
	}

	@Override
	public int hashCode() {
		int result = dimension.hashCode();
		result = 31 * result + orientation.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return dimension.getX()+ " " + dimension.getY() + " " + orientation;
	}
}
