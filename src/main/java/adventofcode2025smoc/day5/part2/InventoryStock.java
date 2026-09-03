package adventofcode2025smoc.day5.part2;

import java.util.ArrayList;
import java.util.List;

public class InventoryStock {
    public Inventory parse(List<String> lines) {
        List<Ranges> ranges = new ArrayList<>();
        List<Long> ingredients = new ArrayList<>();

        boolean readingIngredient = false;
        for (String line : lines) {
            line = line.trim();

            if(line.isEmpty()) {
                readingIngredient = true;
                continue;
            }
            if(!readingIngredient) {
                String[] parts = line.split("-");
                long min = Long.parseLong(parts[0]);
                long max = Long.parseLong(parts[1]);
                ranges.add(new Ranges(min, max));
            }else {
                ingredients.add(Long.parseLong(line));
            }
        }
        return new Inventory(ranges, ingredients);
    }
}
