package adventofcode2025smoc.day7.common;

import java.util.List;

public final class GridBuilder {
    private  final List<String> input;
    private final int width;
    private final int height;
    private final int columStart;

    public GridBuilder(final List<String> input) {
        this.input = input;
        this.width = input.get(0).length();
        this.height = input.size();
        this.columStart = findColumStart(input.getFirst());

    }
    private int findColumStart(String firstRow) {
        int index = firstRow.indexOf('S');
        if (index < 0) {
            return -1;
        }
        return index;
    }
    public char cellPosition(int row, int col) {
        return input.get(row).charAt(col);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getColumStart() {
        return columStart;
    }
}
