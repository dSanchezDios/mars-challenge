package mars.parsers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static mars.model.Instruction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionsParserTest {

	private final InstructionsParser instructionsParser = new InstructionsParser();

	@Test
	void shouldFailWhenInstructionsAreWrong() {
		final var input = "lrbc";

		assertThrows(IllegalArgumentException.class, () -> instructionsParser.parse(input));
	}

	@Test
	void shouldReturnEmptyWhenNull() {
		final var expected = emptyList();

		final var actual = instructionsParser.parse(null);

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnEmptyWhenEmptyTrim() {
		final var expected = emptyList();

		final var actual = instructionsParser.parse("     ");

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnEmptyWhenEmptyInput() {
		final var expected = emptyList();

		final var actual = instructionsParser.parse("");

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnExpectedInstructions() {
		final var input = "frflb";

		final var expected = asList(f,r,f,l,b);

		final var actual = instructionsParser.parse(input);

		assertEquals(expected, actual);
	}
}
