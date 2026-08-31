package adventofcode2025smoc.day2.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InvalidIDFinder {
    public List<Long> findInvalidIDs(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line =  reader.readLine().trim();

        String[] ranges = line.split(",");
        List<Long> invalidIds = new ArrayList<>();

        for (String range : ranges) {
            String trimmed = range.trim();
            if (trimmed.isEmpty()) continue;

            String[] ids = trimmed.split("-");
            long start = Long.parseLong(ids[0]);
            long end = Long.parseLong(ids[1]);

            for (long i = start; i <= end; i++) {
                if (isInvalid(i)) {
                    invalidIds.add(i);
                }
            }
        }
        return invalidIds;
    }
    public boolean isInvalid(long id) {
        String idString = Long.toString(id);

        if  (idString.length() % 2 != 0 ) {
            return false;
        }
        int half = idString.length() / 2;
        return idString.substring(0, half).equals(idString.substring(half));
    }
}