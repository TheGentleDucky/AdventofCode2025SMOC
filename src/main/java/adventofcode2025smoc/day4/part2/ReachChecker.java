package adventofcode2025smoc.day4.part2;

public class ReachChecker {

    private final Matrix matrix;

    public ReachChecker(Matrix matrix) {
        this.matrix = matrix;
    }

    public boolean inReach(int i, int j) {
        int adjacentRolls = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                   }
                    int nr = i + dr;
                    int nc = j + dc;

                    if (matrix.inRange(nr, nc) && matrix.get(nr, nc) == '@') {
                        adjacentRolls++;

                        if (adjacentRolls >= 4)
                            return false;
                    }
                }
            }
         return true;
    }
}
