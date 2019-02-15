package mars.model;

public class Dimension {
	private final Coordinate x;
	private final Coordinate y;

	public Dimension(Coordinate x, Coordinate y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate getX() {
		return x;
	}

	public Coordinate getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Dimension dimension = (Dimension) o;

		if (!x.equals(dimension.x)) return false;
		return y.equals(dimension.y);
	}

	@Override
	public int hashCode() {
		int result = x.hashCode();
		result = 31 * result + y.hashCode();
		return result;
	}
}
