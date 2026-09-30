package adventofcode2025smoc.day6.part1;

import adventofcode2025smoc.day6.common.Problem;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {

    public List<Problem> parse(List<String> lines) {
        if (lines.isEmpty()) return List.of();

        int width = lines.get(0).length();
        List<Problem> result = new ArrayList<>();

        Integer start = null;

        for (int col = 0; col < width; col++) {
            boolean used = columnIsNumber(lines, col);

            if (used && start == null) {
                start = col;
            }

            if (!used && start != null) {
                result.add(extractProblem(lines, start, col - 1));
                start = null;
            }
        }

        if (start != null) {
            result.add(extractProblem(lines, start, width - 1));
        }

        return result;
    }

    private boolean columnIsNumber(List<String> lines, int col){
        for (String s : lines) {
            if (col < s.length() && s.charAt(col) != ' ') {
                return true;
            }
        }
        return false;
    }

    private Problem extractProblem(List<String> lines, int start, int end) {
        List<String> column = new ArrayList<>();
        for (String s : lines) {
            if (start < s.length()){
                column.add(s.substring(start, Math.min(end + 1,s.length())).trim());
            } else {
                column.add("");
            }
        }

        char op = column.get(column.size()-1).charAt(0);

        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < column.size() - 1; i++) {
            String string = column.get(i);
            if (!string.isBlank()) {
                numbers.add(Long.parseLong(string));
            }
        }
        return new Problem(numbers, op);
    }
}
