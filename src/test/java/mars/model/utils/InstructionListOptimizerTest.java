package mars.model.utils;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static mars.model.Instruction.*;
import static mars.model.utils.InstructionListOptimizer.optimize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionListOptimizerTest {

	@Test
	void shouldReturnSameInput() {
		final var input = asList(f, r, b, l);

		final var expected = asList(f, r, b, l);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToRightSix() {
		final var input = asList(r, r, r, r, r, r);

		final var expected = asList(r, r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToRightSeven() {
		final var input = asList(r, r, r, r, r, r, r);

		final var expected = singletonList(l);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToRightEight() {
		final var input = asList(r, r, r, r, r, r, r, r);

		final var expected = Collections.emptyList();

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToLeftSix() {
		final var input = asList(l, l, l, l, l, l);

		final var expected = asList(l, l);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToLeftSeven() {
		final var input = asList(l, l, l, l, l, l, l);

		final var expected = singletonList(r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyTurnToLeftEight() {
		final var input = asList(l, l, l, l, l, l, l, l);

		final var expected = Collections.emptyList();

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedWhenHasOnlyLeftAndRight() {
		final var input = asList(l, r, l, r, l, r, l, r, r);

		final var expected = singletonList(r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedLeftWhenHasOnlyLeftAndRight() {
		final var input = asList(l, r, l, r, l, l, r, l, r, l, l);

		final var expected = singletonList(r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedOptimizedList() {
		final var input = asList(l, l, l, f, l, l, r, f, r, r, l, r);

		final var expected = asList(r, f, l, f, r, r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldConvertThreeRToOneL() {
		final var input = asList(r, r, r);

		final var expected = singletonList(l);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}

	@Test
	void shouldConvertThreeLToOneR() {
		final var input = asList(l, l, l);

		final var expected = singletonList(r);

		final var actual = optimize(input);

		assertEquals(expected, actual);
	}
}
