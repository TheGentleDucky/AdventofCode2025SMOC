package adventofcode2025smoc.day6.part2;

import adventofcode2025smoc.day6.common.Problem;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {
    private final ProblemParser problemParser;

    public WorksheetParser(ProblemParser problemParser) {
        this.problemParser = problemParser;
    }

    public List<Problem> parseLines(List<String> lines)
    {
        if (lines.isEmpty()) return List.of();

        int width = lines.get(0).length();
        List<Problem> result = new ArrayList<Problem>();

        Integer start = null;

        for (int col = 0; col < width; col++){
            boolean used = columnIsNumber(lines, col);

            if(used && start == null){
                start = col;
            }

            if(!used && start != null){
                result.add(problemParser.parseProblem(lines, start, col - 1));
                start = null;
            }
        }

        if(start != null){
            result.add(problemParser.parseProblem(lines, start, width - 1));
        }

        return result;

    }

    private boolean columnIsNumber(List<String> lines, int col){
        for(String line: lines){
            if(col < line.length() && line.charAt(col) != ' '){
                return true;
            }
        }
        return false;
    }
}
