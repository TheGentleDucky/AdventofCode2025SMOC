package adventofcode2025smoc.day10.common;

import java.util.List;

public record Machine(String target, List<Button> buttons, List<Integer> joltageRequirements) {
}
