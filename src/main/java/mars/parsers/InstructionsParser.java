package mars.parsers;

import mars.model.Instruction;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static mars.model.utils.InstructionListOptimizer.optimize;

public class InstructionsParser {
	List<Instruction> parse(String input) {
		if (input == null || input.trim().isEmpty()) {
			return emptyList();
		}

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
