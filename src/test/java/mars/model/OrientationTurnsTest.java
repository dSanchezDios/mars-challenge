package mars.model;

import org.junit.jupiter.api.Test;

import static mars.model.Orientation.E;
import static mars.model.Orientation.N;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrientationTurnsTest {

	@Test
	void shouldReturnEastWhenNorthMovesToRight() {
		assertEquals(E, N.getRight());
	}
}
