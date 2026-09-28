package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.day12.common.Cell;
import adventofcode2025smoc.day12.common.Region;
import adventofcode2025smoc.day12.common.Shape;
import adventofcode2025smoc.day12.common.TreeArea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TreeAreaParser {
    public TreeArea parseTree(Stream<String> lines) {
        List<String> input = lines.toList();
        int separator = findSeparator(input);

        List<Shape> shapes = parseShapes(input.subList(0, separator));
        List<Region> regions = parseRegions(input.subList(separator, input.size()));

        return new TreeArea(shapes, regions);
    }
    private int findSeparator(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).matches("\\d+x\\d+:.*")) {
                return i;
            }
        }
        throw new IllegalArgumentException("No se encontraron regiones en el input");
    }
    private List<Shape> parseShapes(List<String> input) {
        List<Shape> shapes = new ArrayList<>();
        int i = 0;

        while (i < input.size()) {
            if (input.get(i).isBlank()) {
                i++;
                continue;
            }
            String header = input.get(i);
            int index = Integer.parseInt(header.replace(":", ""));

            List<Cell> cells = new ArrayList<>();

            for (int y = 1; y <= 3; y++){
                String row = input.get(i + y);

                for (int x = 0; x < row.length(); x++){
                    if (row.charAt(x) == '#'){
                        cells.add(new Cell(x, y - 1));
                    }
                }
            }
            shapes.add(new Shape(index, cells));
            i += 4;
        }
        return shapes;
    }
    private List<Region> parseRegions(List<String> input) {
        List<Region> regions = new ArrayList<>();

        for (String line : input) {
            String[] parts = line.split(":", 2);

            String[] dimensions = parts[0].trim().split("x");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);

            String[] values = parts[1].trim().split("\\s+");
            List<Integer> quantity = new ArrayList<>();

            for (String value : values) {
                quantity.add(Integer.parseInt(value));
            }
            regions.add(new Region(width, height, quantity));
        }
        return regions;
    }
}
