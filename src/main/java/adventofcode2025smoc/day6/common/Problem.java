package adventofcode2025smoc.day6.common;

import java.util.List;

public class Problem {

    private final List<Long> numbers;
    private final char operator;

    public Problem(List<Long> numbers, char operator) {
        this.numbers = numbers;
        this.operator = operator;
    }

    public List<Long> getNumbers() {
        return numbers;
    }
    public char getOperator() {
        return operator;
    }
}
