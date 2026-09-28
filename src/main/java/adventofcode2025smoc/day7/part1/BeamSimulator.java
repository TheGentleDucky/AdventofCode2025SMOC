package adventofcode2025smoc.day7.part1;

import adventofcode2025smoc.day7.common.GridBuilder;

import java.util.HashSet;
import java.util.Set;

public final class BeamSimulator {
    public int countSplits(GridBuilder grid) {
        Set<Integer> activeBeams = initializeStartingBeam(grid); //Initialize Starting Beam, Mecha Rider Zahard!! TOUUUUUUh!!!
        int totalSplits = 0;

        for (int row = 0; row < grid.getHeight(); row++) {
            Set<Integer> nextBeams = new HashSet<>();
            for (int col : activeBeams) {
                if(isSplitter(grid, row, col)) {
                    totalSplits++;
                    emitSplitBeams(col, grid.getWidth(), nextBeams);
                } else  {
                    nextBeams.add(col);
                }
            }
            activeBeams = nextBeams;
        }
        return totalSplits;
    }
    private Set<Integer> initializeStartingBeam(GridBuilder grid) {
        Set<Integer> beams = new HashSet<>();
        beams.add(grid.getColumStart());
        return beams;
    }
    private boolean isSplitter(GridBuilder grid, int row, int col) {
        return grid.cellPosition(row, col) == '^';
    }
    private void emitSplitBeams(int col, int width, Set<Integer> nextBeams) {
        if (col > 0) {
            nextBeams.add(col - 1);
        }
        if (col < width - 1) {
            nextBeams.add(col + 1);
        }
    }
}
