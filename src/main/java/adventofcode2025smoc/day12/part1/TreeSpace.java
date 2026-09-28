package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.day12.common.Cell;

import java.util.List;

public class TreeSpace {
    private final boolean[][] occupied;

    public TreeSpace(int width, int height) {
        this.occupied = new boolean[height][width];
    }
    public boolean canPlace(Placement placement) {
        for (Cell cell : placement.cells()) {
            if (occupied[cell.y()][cell.x()]) {
                return false;
            }
        }
        return true;
    }
    public void place(Placement placement) {
        setOccupied(placement, true);
    }
    public void remove(Placement placement) {
        setOccupied(placement, false);
    }

    public void setOccupied(Placement placement, boolean value) {
        for (Cell cell : placement.cells()) {
            occupied[cell.y()][cell.x()] = value;
        }
    }
}
