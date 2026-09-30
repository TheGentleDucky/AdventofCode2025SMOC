package adventofcode2025smoc.day6.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day6.common.ProblemChecker;

public class Main {
    static void main() {
        FileProcessor fileProcessor = new FileProcessor();
        var lines = fileProcessor.readLines("D6_Input.txt").toList();

        WorksheetParser worksheetParser = new WorksheetParser();
        var problems = worksheetParser.parse(lines);

        ProblemChecker problemChecker = new ProblemChecker();
        long total = problems.stream().mapToLong(problemChecker::solveProblem).sum();

        System.out.println("Total: " + total);

    }
}
