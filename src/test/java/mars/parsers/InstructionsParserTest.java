package mars.parsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionsParserTest {

	private final InstructionsParser instructionsParser = new InstructionsParser();

	@Test
	void shouldFailWhenInstructionsAreWrong() {
		final var input = "lrbc";

		assertThrows(IllegalArgumentException.class, () -> instructionsParser.parse(input));
	}
}
