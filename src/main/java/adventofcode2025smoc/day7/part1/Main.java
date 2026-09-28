package adventofcode2025smoc.day7.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day7.common.GridBuilder;

import java.util.List;

public class Main {
    static void main() {
        FileProcessor fileProcessor = new FileProcessor();
        List<String> lines = fileProcessor.readLines("D7_Input.txt").toList();

        GridBuilder gridBuilder = new GridBuilder(lines);
        BeamSimulator beamSimulator = new BeamSimulator();

        long totalSplits = beamSimulator.countSplits(gridBuilder);
        System.out.println("Total Splits: " + totalSplits);
    }
}
