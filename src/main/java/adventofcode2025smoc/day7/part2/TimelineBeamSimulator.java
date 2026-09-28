package adventofcode2025smoc.day7.part2;

import adventofcode2025smoc.day7.common.GridBuilder;

import java.util.HashMap;
import java.util.Map;

public final class TimelineBeamSimulator {
//Trazyn, las líneas temporales se salen de control! Debo lazar un canoptograma para catalogar su número.
//Que friki soy por favor.
    public long countTimelines(GridBuilder grid) {
        Map<Integer, Long> activeTimelines = initializeStartingTimeline(grid);

        for (int row = 0; row < grid.getHeight(); row++) {
            Map<Integer, Long> newTimelines = new HashMap<>();

            for (Map.Entry<Integer, Long> entry : activeTimelines.entrySet()) {
                int column = entry.getKey();
                long timelines = entry.getValue();

                if (isSplitter(grid, row, column)) {
                    catalogueTimelines(newTimelines, column - 1, timelines);
                    catalogueTimelines(newTimelines, column + 1, timelines);
                } else {
                    catalogueTimelines(newTimelines, column, timelines);
                }
            }

            activeTimelines = newTimelines;
        }

        return activeTimelines.values().stream().mapToLong(Long::longValue).sum();
    }
    private Map<Integer, Long> initializeStartingTimeline(GridBuilder grid) {
        Map<Integer, Long> timelines = new HashMap<>();
        timelines.put(grid.getColumStart(), 1L);
        return timelines;
    }
    private boolean isSplitter(GridBuilder grid, int row, int column) {
        return grid.cellPosition(row, column) == '^';
    }
    private void catalogueTimelines(Map<Integer, Long> timelines, int column, long amount) {
        timelines.merge(column, amount, Long::sum);
    }
}