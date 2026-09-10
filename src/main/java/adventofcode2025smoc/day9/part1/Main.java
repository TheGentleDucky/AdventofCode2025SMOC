package adventofcode2025smoc.day9.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day9.common.RedTile;
import adventofcode2025smoc.day9.common.TileParser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        FileProcessor fileProcessor = new FileProcessor();
        TileParser tileParser = new TileParser();
        RectangleCalculator rectangleCalculator = new RectangleCalculator();

        List<String> lines = fileProcessor.readLines("D9_Input.txt").toList();
        List<RedTile> redTiles = tileParser.parse(lines);

        long largestArea = rectangleCalculator.calculate(redTiles);
        System.out.println("Largest area: " + largestArea);
    }
}
