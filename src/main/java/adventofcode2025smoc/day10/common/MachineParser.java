package adventofcode2025smoc.day10.common;

import java.util.ArrayList;
import java.util.List;

public class MachineParser {
    private final ButtonParser buttonParser;
    private final JoltageParser joltageParser;

    public MachineParser(ButtonParser buttonParser, JoltageParser joltageParser){
        this.buttonParser = buttonParser;
        this.joltageParser = joltageParser;
    }

    public List<Machine> parser(List<String> input) {
        List<Machine> machines = new ArrayList<>();

        for (String line: input) {
            machines.add(parseMachine(line));
        }
        return machines;
    }

    private Machine parseMachine(String line) {
        int targetStart = line.indexOf('[');
        int targetEnd = line.indexOf(']');

        String target = line.substring(targetStart + 1, targetEnd);

        int joltageStart = line.indexOf('{');
        int joltageEnd = line.indexOf('}');

        String buttonsPart = line.substring(targetEnd + 1, joltageStart);
        String joltagePart = line.substring(joltageStart + 1, joltageEnd);

        List<Button> buttons = buttonParser.parse(buttonsPart);
        List<Integer> joltageRequirements = joltageParser.parse(joltagePart);

        return new Machine(target, buttons, joltageRequirements);
    }

}

