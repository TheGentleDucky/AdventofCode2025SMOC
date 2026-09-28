package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.day12.common.Cell;
import adventofcode2025smoc.day12.common.Region;
import adventofcode2025smoc.day12.common.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlacementGenerator {
    private final ShapeChanger shapeChanger;

    public PlacementGenerator(ShapeChanger shapeChanger) {
        this.shapeChanger = shapeChanger;
    }
    public List<Placement> generatePlacements(Shape shape, Region region) {
        List<Placement> placements = new ArrayList<>();

        Set<List<Cell>> orientations = shapeChanger.getOrientations(shape);

        for (List<Cell> cells : orientations) {
            for (int startY = 0; startY < region.height(); startY++) {
                for (int startX = 0; startX < region.width(); startX++) {

                    if (fits(cells, startX, startY, region)){
                        placements.add(createPlacement(cells, startX, startY));
                    }
                }
            }
        }
        return placements;
    }
    private boolean fits(List<Cell> orientation, int startX, int startY, Region region) {
        for (Cell cell : orientation) {
            int x = startX + cell.x();
            int y = startY + cell.y();

            if (x < 0 || y < 0 || x >= region.width() || y >= region.height()) {
                return false;
            }
        }
        return true;
    }
    private Placement createPlacement(List<Cell> orientation, int startX, int startY) {
        List<Cell> cells = new ArrayList<>();

        for (Cell cell : orientation) {
            cells.add(new Cell(startX + cell.x(), startY + cell.y()));
        }
        return new Placement(cells);
    }
}
