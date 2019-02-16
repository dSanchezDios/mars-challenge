package mars.model;

import java.util.Objects;

public class Map {
	private final Dimension limits;
	private final Obstacles obstacles;

	public Map(Dimension limits, Obstacles obstacles) {
		this.limits = limits;
		this.obstacles = obstacles;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Map map = (Map) o;
		return limits.equals(map.limits) &&
				obstacles.equals(map.obstacles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(limits, obstacles);
	}
}
