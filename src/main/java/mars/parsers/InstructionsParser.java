package mars.parsers;

import mars.model.Instruction;

import java.util.List;
import java.util.stream.Collectors;

import static mars.model.utils.InstructionListOptimizer.optimize;

class InstructionsParser {
	List<Instruction> parse(String input) {
		return optimize(
				input
						.chars()
						.mapToObj(x -> (char) x)
						.map(String::valueOf)
						.map(Instruction::valueOf)
						.collect(Collectors.toList())
		);
	}
}
