package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day10.common.ButtonParser;
import adventofcode2025smoc.day10.common.JoltageParser;
import adventofcode2025smoc.day10.common.Machine;
import adventofcode2025smoc.day10.common.MachineParser;

import java.util.List;

public class Main {
    static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        MachineParser machineParser = new MachineParser(new ButtonParser(), new JoltageParser());
        JoltageSolver joltageSolver = new JoltageSolver();

        List<String> input = fileProcessor.readLines("D10_Input.txt").toList();
        List<Machine> machines = machineParser.parser(input);

        int minPresses = 0;

        for (Machine machine : machines) {
            minPresses += joltageSolver.solve(machine);
        }
        System.out.println("Minimum presses: " + minPresses);

    }
}
