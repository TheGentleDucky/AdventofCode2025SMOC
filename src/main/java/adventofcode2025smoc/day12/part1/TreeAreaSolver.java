package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.day12.common.Region;
import adventofcode2025smoc.day12.common.Shape;

import java.util.ArrayList;
import java.util.List;

public class TreeAreaSolver {

    private final PlacementGenerator placementGenerator;

    public TreeAreaSolver(PlacementGenerator placementGenerator) {
        this.placementGenerator = placementGenerator;
    }

    public boolean canFit(Region region, List<Shape> shapes) {
        int requiredArea = calculateRequiredArea(region, shapes);

        if (requiredArea > region.width() * region.height()) {
            return false;
        }
        List<List<Placement>> placements = generatePlacements(region, shapes);

        int[] remaining = toArray(region.ammount());
        int[] nextPlacement = new int[shapes.size()];

        TreeSpace treeSpace = new TreeSpace(region.width(), region.height());

        return search(treeSpace, remaining, nextPlacement, shapes, placements, requiredArea);
    }

    private boolean search(TreeSpace treeSpace, int[] remaining, int[] nextPlacement, List<Shape> shapes, List<List<Placement>> placements, int remainingArea) {
        if (remainingArea == 0) {
            return true;
        }
        int shapeIndex = findMostRestrictedShape(treeSpace, remaining, nextPlacement, placements);

        if (shapeIndex == -1) {
            return false;
        }
        List<Placement> shapePlacements = placements.get(shapeIndex);

        int oldNextPlacement = nextPlacement[shapeIndex];

        for (int i = oldNextPlacement; i < shapePlacements.size(); i++) {
            Placement placement = shapePlacements.get(i);

            if (!treeSpace.canPlace(placement)) {
                continue;
            }

            treeSpace.place(placement);
            remaining[shapeIndex]--;
            nextPlacement[shapeIndex] = i + 1;

            if (search(treeSpace, remaining, nextPlacement, shapes, placements, remainingArea - shapes.get(shapeIndex).cells().size())) {
                return true;
            }

            nextPlacement[shapeIndex] = oldNextPlacement;
            remaining[shapeIndex]++;
            treeSpace.remove(placement);
        }

        return false;
    }

    private int findMostRestrictedShape(TreeSpace treeSpace, int[] remaining, int[] nextPlacement, List<List<Placement>> placements) {
        int selectedShape = -1;
        int minimumPlacements = Integer.MAX_VALUE;
        for (int shapeIndex = 0; shapeIndex < remaining.length; shapeIndex++) {
            if (remaining[shapeIndex] == 0) {
                continue;
            }
            int possiblePlacements = countPossiblePlacements(treeSpace, placements.get(shapeIndex), nextPlacement[shapeIndex]);
            if (possiblePlacements == 0) {
                return -1;
            }
            if (possiblePlacements < minimumPlacements) {
                minimumPlacements = possiblePlacements;
                selectedShape = shapeIndex;
            }
        }

        return selectedShape;
    }

    private int countPossiblePlacements(TreeSpace treeSpace, List<Placement> placements, int startIndex) {
        int count = 0;
        for (int i = startIndex; i < placements.size(); i++) {
            if (treeSpace.canPlace(placements.get(i))) {
                count++;
            }
        }

        return count;
    }

    private List<List<Placement>> generatePlacements(Region region, List<Shape> shapes) {
        List<List<Placement>> result = new ArrayList<>();
        for (Shape shape : shapes) {
            result.add(placementGenerator.generatePlacements(shape, region));
        }
        return result;
    }

    private int[] toArray(List<Integer> quantities) {
        int[] result = new int[quantities.size()];
        for (int i = 0; i < quantities.size(); i++) {
            result[i] = quantities.get(i);
        }

        return result;
    }

    private int calculateRequiredArea(Region region, List<Shape> shapes) {
        int requiredArea = 0;
        for (int i = 0; i < region.ammount().size(); i++) {
            requiredArea += region.ammount().get(i) * shapes.get(i).cells().size();
        }
        return requiredArea;
    }
}