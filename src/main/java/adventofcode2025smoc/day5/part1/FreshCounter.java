package adventofcode2025smoc.day5.part1;

import java.util.List;

public class FreshCounter {
    public long countFresh(List<Long> ingredients, IngredientChecker checker) {
        return ingredients.stream().filter(checker::isFresh).count();
    }
}
