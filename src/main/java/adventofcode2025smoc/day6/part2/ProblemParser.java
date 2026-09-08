package adventofcode2025smoc.day6.part2;

import adventofcode2025smoc.day6.common.Problem;

import java.util.ArrayList;
import java.util.List;

public class ProblemParser {
    public Problem parseProblem(List<String> lines, int start, int end) {
        List<String> column = new ArrayList<>();

        for (String line : lines) {
            if(start < line.length()) {
                int safeEnd = Math.min(end + 1, line.length());
                column.add(line.substring(start, safeEnd));
            } else {
                column.add("");
            }
        }
        char op =  column.get(column.size()-1).charAt(0);

        List<Long> numbers = new ArrayList<>();
        int width = column.stream().mapToInt(String::length).max().orElse(0);

        for(int col = width - 1; col >= 0; col--) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int row = 0; row < column.size() -1; row++) {
                String line = column.get(row);

                if (col <  line.length() && Character.isDigit(line.charAt(col))) {
                    stringBuilder.append(line.charAt(col));
                }
            }
            if(!stringBuilder.isEmpty()){
                numbers.add(Long.parseLong(stringBuilder.toString()));
            }
        }
        return new Problem(numbers, op);
    }
}
