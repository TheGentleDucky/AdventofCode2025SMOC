package adventofcode2025smoc.day5.part1;

import java.util.List;

public class IngredientChecker {
    private final List<Ranges> ranges;

    public IngredientChecker(List<Ranges> ranges) {
        this.ranges = ranges;
    }

    public boolean isFresh(long value){
        return ranges.stream().anyMatch(range -> range.contains(value));
    }
}
