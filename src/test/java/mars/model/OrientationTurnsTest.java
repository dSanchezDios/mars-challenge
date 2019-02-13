package mars.model;

import org.junit.jupiter.api.Test;

import static mars.model.Orientation.*;
import static mars.model.Orientation.W;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrientationTurnsTest {

	@Test
	void shouldReturnEastWhenNorthMovesToRight() {
		assertEquals(E, N.getRight());
	}

	@Test
	void shouldReturnSouthWhenEastMovesToRight() {
		assertEquals(S, E.getRight());
	}

	@Test
	void shouldReturnWestWhenSouthMovesToRight() {
		assertEquals(W, S.getRight());
	}

	@Test
	void shouldReturnNorthWhenWestMovesToRight() {
		assertEquals(N, W.getRight());
	}

}
