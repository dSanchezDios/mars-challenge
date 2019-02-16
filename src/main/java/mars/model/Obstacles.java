package mars.model;

import java.util.HashSet;
import java.util.Objects;

public class Obstacles {
	private HashSet<Dimension> obstaclesList;

	public Obstacles(HashSet<Dimension> obstaclesList) {
		this.obstaclesList = obstaclesList;
	}

	public HashSet<Dimension> getObstaclesList() {
		return obstaclesList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Obstacles obstacles = (Obstacles) o;
		return obstaclesList.equals(obstacles.obstaclesList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(obstaclesList);
	}
}
