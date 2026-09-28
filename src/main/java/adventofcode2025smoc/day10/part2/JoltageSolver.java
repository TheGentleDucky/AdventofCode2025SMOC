package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.day10.common.Button;
import adventofcode2025smoc.day10.common.Machine;

import java.util.*;

public class JoltageSolver {
    private int minimumPresses;

    public int solve(Machine machine) {
        List<Integer> target = machine.joltageRequirements();
        minimumPresses = Integer.MAX_VALUE;
        List<Integer> initialLevels = buildInitialLevels(target.size());
        search(machine.buttons(), target, 0, initialLevels, 0);

        return minimumPresses;
    }

    private void search(List<Button> buttons, List<Integer> target, int buttonIndex, List<Integer> levels, int presses) {
        if (buttonIndex == buttons.size()) {
            checkSolution(target, levels, presses);
            return;
        }

        Button button = buttons.get(buttonIndex);
        int maximumPresses = calculateMaxPresses(button, levels, target);
        for (int count = 0; count < maximumPresses; count++) {
            int totalPresses = presses + count;

            if (totalPresses >= minimumPresses) {
                break;
            }
            List<Integer> nextLevels = applyButtons(levels, button, count);
            search(buttons, target, buttonIndex + 1, nextLevels, totalPresses);
        }
    }
    private int calculateMaxPresses(Button button, List<Integer> levels, List<Integer> target) {
        if (button.lights().isEmpty()) {
            return 0;
        }
        int maximumPresses = Integer.MAX_VALUE;
        for (int position : button.lights()){
            int remaining = target.get(position) - levels.get(position);
            if (remaining < maximumPresses) {
                maximumPresses = remaining;
            }
        }
        return maximumPresses;
    }

    private List<Integer> buildInitialLevels(int size) {
        List<Integer> levels = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            levels.add(0);
        }
        return levels;
    }
    private List<Integer> applyButtons(List<Integer> levels, Button button, int count) {
        List<Integer> newLevels = new ArrayList<>(levels);
        for (int position : button.lights()) {
            newLevels.set(position, levels.get(position) + count);
        }
        return newLevels;
    }
    private void checkSolution(List<Integer> target, List<Integer> levels, int presses) {
        if (levels.equals(target) && presses < minimumPresses){
            minimumPresses = presses;
        }
    }
}
