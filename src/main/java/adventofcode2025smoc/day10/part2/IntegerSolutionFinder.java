package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.day10.common.Button;

import java.util.ArrayList;
import java.util.List;

public class IntegerSolutionFinder {

    private static final double EPSILON = 1e-9;

    private final GaussianEliminator gaussianEliminator;

    private long minPresses;

    public IntegerSolutionFinder(GaussianEliminator gaussianEliminator) {
        this.gaussianEliminator = gaussianEliminator;
    }

    public long findMinimum(List<Button> buttons, List<Integer> target) {
        double[][] matrix = createMatrix(buttons, target);

        GaussianEliminator.ReducedSystem system = gaussianEliminator.reduce(matrix, buttons.size());

        List<Integer> freeColumns = findFreeColumns(system.pivotColumns(), system.pivotCount(), buttons.size());

        int[] freeValues = new int[freeColumns.size()];
        int[] maximumValues = maximumValues(buttons, target, freeColumns);

        minPresses = Long.MAX_VALUE;

        search(system.matrix(), system.pivotColumns(), system.pivotCount(), freeColumns, maximumValues, freeValues, 0, 0
        );

        if (minPresses == Long.MAX_VALUE) {
            throw new IllegalArgumentException("Machine has no integer solution");
        }

        return minPresses;
    }

    private double[][] createMatrix(List<Button> buttons, List<Integer> target) {

        double[][] matrix = new double[target.size()][buttons.size() + 1];

        for (int button = 0; button < buttons.size(); button++) {
            for (int counter : buttons.get(button).lights()) {
                matrix[counter][button] = 1;
            }
        }

        for (int counter = 0; counter < target.size(); counter++) {
            matrix[counter][buttons.size()] = target.get(counter);
        }

        return matrix;
    }

    private List<Integer> findFreeColumns(int[] pivotColumns, int pivotCount, int variableCount) {

        List<Integer> freeColumns = new ArrayList<>();

        for (int column = 0; column < variableCount; column++) {
            if (!isPivot(column, pivotColumns, pivotCount)) {
                freeColumns.add(column);
            }
        }

        return freeColumns;
    }

    private boolean isPivot(int column, int[] pivotColumns, int pivotCount) {

        for (int i = 0; i < pivotCount; i++) {
            if (pivotColumns[i] == column) {
                return true;
            }
        }

        return false;
    }

    private int[] maximumValues(List<Button> buttons, List<Integer> target, List<Integer> freeColumns) {

        int[] maximums = new int[freeColumns.size()];

        for (int i = 0; i < freeColumns.size(); i++) {
            Button button = buttons.get(freeColumns.get(i));

            int maximum = Integer.MAX_VALUE;

            for (int counter : button.lights()) {
                maximum = Math.min(maximum, target.get(counter));
            }

            maximums[i] = maximum;
        }

        return maximums;
    }

    private void search(double[][] matrix, int[] pivotColumns, int pivotCount, List<Integer> freeColumns, int[] maximumValues, int[] freeValues, int freeIndex, long presses) {

        if (presses >= minPresses) {
            return;
        }

        if (freeIndex == freeColumns.size()) {
            evaluateSolution(matrix, pivotColumns, pivotCount, freeColumns, freeValues, presses
            );
            return;
        }

        for (int value = 0; value <= maximumValues[freeIndex]; value++) {
            freeValues[freeIndex] = value;

            search(matrix, pivotColumns, pivotCount, freeColumns, maximumValues, freeValues, freeIndex + 1, presses + value
            );
        }
    }
    private void evaluateSolution(double[][] matrix, int[] pivotColumns, int pivotCount, List<Integer> freeColumns, int[] freeValues, long freePresses) {
        int variableCount = matrix[0].length - 1;
        long[] solution = new long[variableCount];

        for (int i = 0; i < freeColumns.size(); i++) {
            solution[freeColumns.get(i)] = freeValues[i];
        }

        for (int row = 0; row < pivotCount; row++) {
            int pivotColumn = pivotColumns[row];
            double value = matrix[row][variableCount];

            for (int freeColumn : freeColumns) {
                value -= matrix[row][freeColumn] * solution[freeColumn];
            }

            long rounded = Math.round(value);

            if (Math.abs(value - rounded) > EPSILON || rounded < 0) {
                return;
            }

            solution[pivotColumn] = rounded;
        }

        if (isValidSolution(matrix, solution)) {
            long total = freePresses;

            for (int i = 0; i < pivotCount; i++) {
                total += solution[pivotColumns[i]];
            }

            minPresses = Math.min(minPresses, total);
        }
    }
    private boolean isValidSolution(double[][] matrix, long[] solution) {
        int variables = solution.length;

        for (double[] row : matrix) {
            double result = 0;

            for (int column = 0; column < variables; column++) {
                result += row[column] * solution[column];
            }

            if (Math.abs(result - row[variables]) > EPSILON) {
                return false;
            }
        }
        return true;
    }
}