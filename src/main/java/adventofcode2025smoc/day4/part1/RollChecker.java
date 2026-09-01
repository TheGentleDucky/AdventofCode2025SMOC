package adventofcode2025smoc.day4.part1;

public class RollChecker {

    private final Matrix matrix;
    private final ReachChecker reachChecker;

    public RollChecker(Matrix matrix) {
        this.matrix = matrix;
        this.reachChecker = new ReachChecker(matrix);
    }

    public int rollsInReach() {
        int count = 0;

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                if (matrix.get(i, j) == '@' && reachChecker.inReach(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
