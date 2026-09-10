package adventofcode2025smoc.day9.part1;

import adventofcode2025smoc.day9.common.RedTile;

import java.util.List;

public class RectangleCalculator {
    public long calculate(List<RedTile> redTiles) {
        long largestArea = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                long area = calculateArea(redTiles.get(i), redTiles.get(j));
                if (area > largestArea) {
                    largestArea = area;
                }
            }
        }
        return largestArea;
    }
    private long calculateArea(RedTile first, RedTile second) {
        int width = Math.abs(first.x() - second.x()) +1;
        int height = Math.abs(first.y() - second.y()) +1;

        return (long) width * height;
    }
}
