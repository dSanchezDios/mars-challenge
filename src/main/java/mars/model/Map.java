package mars.model;

import java.util.HashSet;
import java.util.Objects;

public class Map {
	private final Dimension limits;
	private final HashSet<Dimension> obstacles;

	public Map(Dimension limits, HashSet<Dimension> obstacles) {
		this.limits = limits;
		this.obstacles = obstacles;
	}

	public Dimension getLimits() {
		return limits;
	}

	public HashSet<Dimension> getObstacles() {
		return obstacles;
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
