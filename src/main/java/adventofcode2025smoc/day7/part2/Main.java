package adventofcode2025smoc.day7.part2;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day7.common.GridBuilder;

import java.util.List;

public class Main {
    static void main() {
        FileProcessor fileProcessor = new FileProcessor();
        List<String> lines = fileProcessor.readLines("D7_Input.txt").toList();

        GridBuilder gridBuilder = new GridBuilder(lines);
        TimelineBeamSimulator simulator = new TimelineBeamSimulator();

        long totalTimelines = simulator.countTimelines(gridBuilder);
        System.out.println("Total timelines: " + totalTimelines);
    }
}
