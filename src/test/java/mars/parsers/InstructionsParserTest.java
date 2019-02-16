package mars.parsers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
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
	void shouldReturnExpectedInstructions() {
		final var input = "frflb";

		final var expected = asList(f,r,f,l,b);

		final var actual = instructionsParser.parse(input);

		assertEquals(expected, actual);
	}
}
