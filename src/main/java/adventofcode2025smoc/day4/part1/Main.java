package adventofcode2025smoc.day4.part1;

import adventofcode2025smoc.FileProcessor;


public class Main {
    static void main(String[] args) {
        FileProcessor fp = new FileProcessor();
        var lines = fp.readLines("D4_Input.txt").toList();

        Matrix matrix = Matrix.fromLines(lines);
        RollChecker rollChecker = new RollChecker(matrix);

        System.out.println("Rollos al alcanze: " + rollChecker.rollsInReach());


    }
}
