package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.day10.common.Machine;

public class JoltageSolver {
    private final IntegerSolutionFinder solutionFinder;

    public JoltageSolver() {
        this.solutionFinder = new IntegerSolutionFinder(new GaussianEliminator());
    }
    public int solve(Machine machine) {
        return Math.toIntExact(solutionFinder.findMinimum(machine.buttons(), machine.joltageRequirements()));
    }
}