package adventofcode2025smoc.day2.part2;

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
        int len = idString.length();

        for (int chunkSize = 1; chunkSize < len / 2; chunkSize++) {
            if (len % chunkSize != 0)
                continue;

            String chunk = idString.substring(0, chunkSize);

            boolean isValid = true;
            for (int pos = chunkSize; pos < len; pos += chunkSize) {
                if (!idString.startsWith(chunk, pos)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid)
                return true;
        }
        return false;
    }
}
