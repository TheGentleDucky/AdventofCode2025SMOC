package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.day12.common.Cell;
import adventofcode2025smoc.day12.common.Shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShapeChanger {
    public Set<List<Cell>> getOrientations(Shape shape) {
        Set<List<Cell>> orientations = new HashSet<>();

        List<Cell> current = shape.cells();

        for (int i = 0; i < 4; i++){
            orientations.add(normalize(current));
            orientations.add(normalize(flip(current)));

            current = rotate(current);
        }
        return orientations;
    }
    private List<Cell> flip(List<Cell> current) {
        List<Cell> flipped = new ArrayList<>();

        for (Cell cell : current) {
            flipped.add(new Cell(-cell.x(), cell.y()));
        }
        return flipped;
    }
    private List<Cell> rotate(List<Cell> current) {
        List<Cell> rotated = new ArrayList<>();

        for (Cell cell : current) {
            rotated.add(new Cell(-cell.y(), cell.x()));
        }
        return rotated;
    }

    private List<Cell> normalize(List<Cell> current) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Cell cell : current) {
            minX = Math.min(minX, cell.x());
            minY = Math.min(minY, cell.y());
        }
        List<Cell> normalized = new ArrayList<>();

        for (Cell cell : current) {
            normalized.add(new Cell(cell.x() - minX, cell.y() - minY));
        }
        return normalized;
    }
}
