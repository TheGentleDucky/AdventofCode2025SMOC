package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.day10.common.Button;
import adventofcode2025smoc.day10.common.Machine;

import java.util.*;

public class JoltageSolver {
    public int solve(Machine machine) {
        List<Integer> target = machine.joltageRequirements();
        List<Integer> initialStates = createInitialStates(target.size());

        Queue<JoltageState> queue = new ArrayDeque<>();
        Set<List<Integer>> visited = new HashSet<>();

        queue.add(new JoltageState(initialStates, 0));
        visited.add(initialStates);

        int exploredStates = 0;

        while (!queue.isEmpty()) {
            JoltageState current = queue.poll();
            exploredStates++;

            if (exploredStates % 1000000 == 0){
                System.out.println("Estados explorados: " + exploredStates);
            }

            if (current.levels().equals(target)) {
                return current.presses();
            }
            for (Button button : machine.buttons()) {
                List<Integer> nextState = pressButton(current.levels(), button, target);

                if (nextState != null && visited.add(nextState)) {
                    queue.add(new JoltageState(nextState, current.presses() + 1));
                }
            }
        }
        return -1;
    }
    private List<Integer> createInitialStates(int size) {
        List<Integer> levels = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            levels.add(0);
        }
        return levels;
    }
    private List<Integer> pressButton(List<Integer> current, Button button, List<Integer> target) {
        List<Integer> pressed = new ArrayList<>(current);

        for (int count : button.lights()) {
            pressed.set(count, pressed.get(count) + 1);

            if (pressed.get(count) > target.get(count)) {
                return null;
            }
        }
        return List.copyOf(pressed);
    }
}
