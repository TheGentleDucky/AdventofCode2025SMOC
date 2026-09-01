package adventofcode2025smoc.day4.part1;

import java.util.List;

public class Matrix {
    private final char[][] matrix;
    private final int rows;
    private final int cols;

    public Matrix(char[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public static Matrix fromLines(List<String> lines) {
        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        return new Matrix(matrix);
    }

    public boolean inRange(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public char get(int row, int col) {
        return matrix[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void set(int i, int j, char c) {
        matrix[i][j] = c;
    }
}