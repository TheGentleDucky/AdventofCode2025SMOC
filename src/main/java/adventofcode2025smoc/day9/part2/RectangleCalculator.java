package adventofcode2025smoc.day9.part2;

import adventofcode2025smoc.day9.common.RedTile;

import java.util.List;

public class RectangleCalculator {
    public long calculate(List<RedTile> redTiles) {
        long largestArea = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                RedTile first = redTiles.get(i);
                RedTile second = redTiles.get(j);

                if (!isValidRectangle(first, second, redTiles)) {
                    continue;
                }

                long area = calculateArea(first, second);

                if (area > largestArea) {
                    largestArea = area;
                }
            }
        }

        return largestArea;
    }

    private boolean isValidRectangle(RedTile first, RedTile second, List<RedTile> redTiles) {

        int minX = Math.min(first.x(), second.x());
        int maxX = Math.max(first.x(), second.x());
        int minY = Math.min(first.y(), second.y());
        int maxY = Math.max(first.y(), second.y());

        for (int i = 0; i < redTiles.size(); i++) {
            RedTile start = redTiles.get(i);
            RedTile end = redTiles.get((i + 1) % redTiles.size());

            if (start.x() == end.x()) {
                int x = start.x();

                int edgeMinY = Math.min(start.y(), end.y());
                int edgeMaxY = Math.max(start.y(), end.y());

                if (x > minX && x < maxX && edgeMinY < maxY && edgeMaxY > minY) {
                    return false;
                }
            } else {
                int y = start.y();

                int edgeMinX = Math.min(start.x(), end.x());
                int edgeMaxX = Math.max(start.x(), end.x());

                if (y > minY && y < maxY
                        && edgeMinX < maxX && edgeMaxX > minX) {
                    return false;
                }
            }
        }

        double centerX = (minX + maxX) / 2.0;
        double centerY = (minY + maxY) / 2.0;

        return isInsideOrOnBoundary(centerX, centerY, redTiles);
    }

    private boolean isInsideOrOnBoundary(double x, double y, List<RedTile> redTiles) {

        boolean inside = false;

        for (int i = 0; i < redTiles.size(); i++) {
            RedTile first = redTiles.get(i);
            RedTile second = redTiles.get((i + 1) % redTiles.size());

            if (first.y() == second.y()) {
                continue;
            }

            int minY = Math.min(first.y(), second.y());
            int maxY = Math.max(first.y(), second.y());

            if (y < minY || y > maxY) {
                continue;
            }

            double intersectionX = first.x();

            if (x < intersectionX) {
                inside = !inside;
            }
        }

        return inside;
    }

    private long calculateArea(RedTile first, RedTile second) {
        long width = Math.abs(first.x() - second.x()) +1;
        long height = Math.abs(first.y() - second.y()) +1;

        return width * height;
    }
}

