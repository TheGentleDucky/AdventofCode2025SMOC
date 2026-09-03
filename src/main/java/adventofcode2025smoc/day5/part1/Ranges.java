package adventofcode2025smoc.day5.part1;

public class Ranges {

    private  final long  min;
    private final long max;

    public Ranges(long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("Los rangos deben ser de menor a mayor");
        }
        this.min = min;
        this.max = max;
    }
    public long getMin() {
        return min;
    }
    public long getMax() {
        return max;
    }

    public boolean contains(long value) {
        return value >= min && value <= max;
    }
}
