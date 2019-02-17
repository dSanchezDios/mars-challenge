package mars.model;

import org.junit.jupiter.api.Test;

import static mars.model.Orientation.*;
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

	@Test
	void shouldReturnSouthWhenWestMovesToLeft() {
		assertEquals(S, W.getLeft());
	}

	@Test
	void shouldReturnWestWhenNorthMovesToLeft() {
		assertEquals(W, N.getLeft());
	}

	@Test
	void shouldReturnNorthWhenEastMovesToLeft() {
		assertEquals(N, E.getLeft());
	}

	@Test
	void shouldReturnEastWhenSouthMovesToLeft() {
		assertEquals(E, S.getLeft());
	}
}
