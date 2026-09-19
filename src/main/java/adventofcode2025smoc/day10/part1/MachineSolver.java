package adventofcode2025smoc.day10.part1;

import adventofcode2025smoc.day10.common.Button;
import adventofcode2025smoc.day10.common.Machine;

public class MachineSolver {
    public int solve(Machine machine) {
        int buttonCount = machine.buttons().size();
        int totalCombos = 1 << buttonCount;
        int minimumPresses = Integer.MAX_VALUE;

        for (int combination = 0; combination < totalCombos; combination++) {
            boolean[] lights = new boolean[machine.target().length()];
            int presses = 0;

            for (int buttonIndex = 0; buttonIndex < buttonCount; buttonIndex++) {
                if(isButtonPressed(combination, buttonIndex)){
                    toggleLights(lights, machine.buttons().get(buttonIndex));
                    presses++;
                }
            }
            if (matchesTarget(lights, machine.target()) && presses < minimumPresses) {
                minimumPresses = presses;
            }
        }
        return minimumPresses;
    }

    private boolean isButtonPressed(int combination, int buttonIndex){
        return (combination & (1 << buttonIndex)) != 0;
    }
    private void toggleLights(boolean[] lights, Button button) {
        for (int light : button.lights()) {
            lights[light] = !lights[light];
        }
    }
    private boolean matchesTarget(boolean[] lights, String target) {
        for (int i = 0; i < lights.length; i++) {
            boolean targetIsOn = target.charAt(i) == '#';

            if (lights[i] != targetIsOn) {
                return false;
            }
        }
        return true;
    }
}
