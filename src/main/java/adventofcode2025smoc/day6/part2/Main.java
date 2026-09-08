package adventofcode2025smoc.day6.part2;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day6.common.ProblemChecker;

public class Main {
    static void main() {
        FileProcessor fp = new FileProcessor();
        var lines = fp.readLines("D6_Input.txt").toList();

        ProblemParser problemParser = new ProblemParser();
        WorksheetParser worksheetParser = new WorksheetParser(problemParser);

        var problems = worksheetParser.parseLines(lines);

        ProblemChecker checker = new ProblemChecker();

        long total = problems.stream().mapToLong(checker::solveProblem).sum();

        System.out.println("Total: " + total);

    }
}
