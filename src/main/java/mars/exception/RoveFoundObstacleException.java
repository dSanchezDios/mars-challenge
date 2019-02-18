package mars.exception;

import mars.model.Position;

public class RoveFoundObstacleException extends RuntimeException {
	public RoveFoundObstacleException(Position lastPosition) {
		super("Next position is an obstacle, rover stopped at " + lastPosition);
	}
}
