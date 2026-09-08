package adventofcode2025smoc.day6.common;

public class ProblemChecker {
    public long solveProblem(Problem problem){
        long result = problem.getOperator() == '+' ? 0 : 1;

        for(long n : problem.getNumbers()){
            if(problem.getOperator() == '+'){
                result += n;
            } else {
                result *= n;
            }
        }
        return result;
    }
}
