package mars.parsers;

import mars.model.Rover;

public class RoverParser {

	private final MapParser mapParser;
	private final InstructionsParser instructionsParser;
	private final PositionParser positionParser;

	public RoverParser(MapParser mapParser, InstructionsParser instructionsParser, PositionParser positionParser) {
		this.mapParser = mapParser;
		this.instructionsParser = instructionsParser;
		this.positionParser = positionParser;
	}

	Rover parse(String mapSize, String obstacles, String instructions, String position) {
		return new Rover(
				mapParser.parse(mapSize, obstacles),
				instructionsParser.parse(instructions),
				positionParser.parse(position)
		);
	}
}
