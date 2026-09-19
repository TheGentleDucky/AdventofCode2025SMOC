package adventofcode2025smoc.day10.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day10.common.ButtonParser;
import adventofcode2025smoc.day10.common.JoltageParser;
import adventofcode2025smoc.day10.common.Machine;
import adventofcode2025smoc.day10.common.MachineParser;

import java.util.List;

public class Main {
    static void main(String[] args) {
        FileProcessor fp = new FileProcessor();
        MachineParser machineParser = new MachineParser(new ButtonParser(), new JoltageParser());

        MachineSolver machineSolver = new MachineSolver();
        List<String> input = fp.readLines("D10_Input.txt").toList();
        List<Machine> machines = machineParser.parser(input);

        int minPresses = 0;
        for (Machine machine : machines) {
            minPresses += machineSolver.solve(machine);
        }
        System.out.println("Minimum presses: " + minPresses);

    }
}
