package adventofcode2025smoc.day2.common;

import java.util.List;

public class InvalidIDSum {
    public long sum(List<Long> ids) {
        long sum = 0;
        for (long id : ids) {
            sum += id;
        }
        return sum;
    }
}
