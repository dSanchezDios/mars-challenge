package mars.model.utils;

import mars.model.Instruction;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.util.Collections.nCopies;
import static java.util.Collections.singletonList;

public class InstructionListOptimizer {

	public static List<Instruction> optimize(List<Instruction> input) {
		final var optimized = new ArrayList<Instruction>();
		final var listForOptimize = new ArrayList<Instruction>();

		input.forEach(
				instruction -> {
					if (instruction == Instruction.f || instruction == Instruction.b) {
						optimized.addAll(optimizeTurns(listForOptimize));
						listForOptimize.clear();
						optimized.add(instruction);
					} else {
						listForOptimize.add(instruction);
					}
				});

		optimized.addAll(optimizeTurns(listForOptimize));

		return optimized;
	}

	private static List<Instruction> optimizeTurns(List<Instruction> input) {
		var numberOfRights = input.stream().filter(instruction -> instruction == Instruction.l).count();
		var numberOfLefts = input.stream().filter(instruction -> instruction == Instruction.r).count();

		var total = (int) (numberOfRights - numberOfLefts) % 4;

		if (abs(total) == 3) {
			return singletonList(total > 0 ? Instruction.r : Instruction.l);
		}

		return createListOfInstructions(total);
	}

	private static List<Instruction> createListOfInstructions(int total) {
		return (nCopies(abs(total), total > 0 ? Instruction.l : Instruction.r));
	}
}
