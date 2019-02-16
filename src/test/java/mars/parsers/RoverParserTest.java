package mars.parsers;

import mars.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static mars.model.Instruction.*;
import static mars.model.Instruction.b;
import static mars.model.Orientation.S;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoverParserTest {

	private final MapParser mapParser = Mockito.mock(MapParser.class);
	private final InstructionsParser instructionsParser = Mockito.mock(InstructionsParser.class);
	private final PositionParser positionParser = Mockito.mock(PositionParser.class);
	private final RoverParser roverParser = new RoverParser(mapParser, instructionsParser, positionParser);

	@Test
	void shouldReturnExpected() {
		final HashSet<Dimension> obstacles = new HashSet<>();
		obstacles.add(new Dimension(new Coordinate(2), new Coordinate(3)));

		final var map = new Map(
				new Dimension(new Coordinate(5), new Coordinate(6)),
				new Obstacles(obstacles)
		);

		final var instructionList = asList(l, r, f, b, l, r, f, b);
		final var position = new Position(
				new Dimension(new Coordinate(0), new Coordinate(0)), S
		);

		final var expected = new Rover(
				map,
				instructionList,
				position
		);

		final var sizeInput = "5 6";
		final var obstaclesInput = "2 3\n";
		final var instructionsInput = "lrfblrfb";
		final var positionInput = "0 0 S";

		when(mapParser.parse(sizeInput, obstaclesInput)).thenReturn(map);
		when(instructionsParser.parse(instructionsInput)).thenReturn(instructionList);
		when(positionParser.parse(positionInput)).thenReturn(position);

		final var actual = roverParser.parse(
				sizeInput,
				obstaclesInput,
				instructionsInput,
				positionInput
		);

		assertEquals(expected, actual);
	}
}
