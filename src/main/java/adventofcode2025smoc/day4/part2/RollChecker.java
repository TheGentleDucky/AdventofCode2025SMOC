package adventofcode2025smoc.day4.part2;

public class RollChecker {

    private final Matrix matrix;
    private final ReachChecker reachChecker;

    public RollChecker(Matrix matrix) {
        this.matrix = matrix;
        this.reachChecker = new ReachChecker(matrix);
    }
    public int rollsInReach() {
        int count = 0;
        boolean removed;

        do {
            removed = false;

            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getCols(); j++) {
                    if (matrix.get(i, j) == '@' && reachChecker.inReach(i, j)) {
                        matrix.set(i, j, '.');
                        count++;
                        removed = true;
                    }
                }
            }
        } while (removed);
        return count;
    }
}
