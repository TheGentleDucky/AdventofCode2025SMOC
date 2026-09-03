package adventofcode2025smoc.day5.part2;

import java.util.Comparator;
import java.util.List;

public class FreshCounter {
    public long freshInRange(List<Ranges> ranges) {
        if (ranges.isEmpty()) return 0;

        var sorted = ranges.stream().sorted(Comparator.comparingLong(r -> r.getMin())).toList();

        long total = 0;

        long currentMin = sorted.get(0).getMin();
        long currentMax = sorted.get(0).getMax();

        for (int i = 1; i < sorted.size(); i++) {
            Ranges range = sorted.get(i);

            if (range.getMin() <= currentMax) { //Tiene sentido que sea al mayor en vez de al menor, YOU BUFFOON!
                currentMax = Math.max(currentMax, range.getMax());
            }else {
                total += currentMax - currentMin + 1;
                currentMin = range.getMin();
                currentMax = range.getMax();
            }
        }
        total += currentMax - currentMin + 1;
        return total;
    }
}
