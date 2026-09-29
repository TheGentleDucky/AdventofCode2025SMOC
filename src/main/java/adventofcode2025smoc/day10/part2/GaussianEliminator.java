package adventofcode2025smoc.day10.part2;

public class GaussianEliminator {

    private static final double EPSILON = 1e-9;

    public ReducedSystem reduce(double[][] matrix, int variables) {
        int row = 0;

        int[] pivotColumns = new int[matrix.length];
        int pivotCount = 0;

        for (int column = 0; column < variables && row < matrix.length; column++) {
            int pivotRow = findPivotRow(matrix, row, column);

            if (pivotRow == -1) {
                continue;
            }

            swapRows(matrix, row, pivotRow);
            normalizeRow(matrix, row, column);
            eliminateColumn(matrix, row, column);

            pivotColumns[pivotCount] = column;
            pivotCount++;
            row++;
        }

        checkForNoSolution(matrix, variables);

        return new ReducedSystem(matrix, pivotColumns, pivotCount);
    }

    private int findPivotRow(double[][] matrix, int startRow, int column) {
        for (int row = startRow; row < matrix.length; row++) {
            if (Math.abs(matrix[row][column]) > EPSILON) {
                return row;
            }
        }

        return -1;
    }

    private void swapRows(double[][] matrix, int first, int second) {
        double[] temporary = matrix[first];
        matrix[first] = matrix[second];
        matrix[second] = temporary;
    }

    private void normalizeRow(double[][] matrix, int row, int pivotColumn) {
        double pivot = matrix[row][pivotColumn];

        for (int column = pivotColumn; column < matrix[row].length; column++) {
            matrix[row][column] /= pivot;
        }
    }

    private void eliminateColumn(double[][] matrix, int pivotRow, int pivotColumn) {
        for (int row = 0; row < matrix.length; row++) {
            if (row == pivotRow) {
                continue;
            }

            double factor = matrix[row][pivotColumn];

            if (Math.abs(factor) < EPSILON) {
                continue;
            }

            for (int column = pivotColumn; column < matrix[row].length; column++) {
                matrix[row][column] -= factor * matrix[pivotRow][column];
            }
        }
    }

    private void checkForNoSolution(double[][] matrix, int variables) {
        for (double[] row : matrix) {
            boolean allZero = true;

            for (int column = 0; column < variables; column++) {
                if (Math.abs(row[column]) > EPSILON) {
                    allZero = false;
                    break;
                }
            }

            if (allZero && Math.abs(row[variables]) > EPSILON) {
                throw new IllegalArgumentException("Machine has no solution");
            }
        }
    }

    public record ReducedSystem(double[][] matrix, int[] pivotColumns, int pivotCount) {
    }
}