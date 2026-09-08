package adventofcode2025smoc.day8.common;

import java.util.List;
import java.util.stream.Stream;

public class JunctionBoxParser {
    public List<JunctionBox> parseJunctionBox(Stream<String> lines) {
        return lines.map(this::parseLine).toList();
    }

    private JunctionBox parseLine(String line) {
        String[] coords = line.split(",");

        long x = Long.parseLong(coords[0]);
        long y = Long.parseLong(coords[1]);
        long z = Long.parseLong(coords[2]);

        return new JunctionBox(x, y, z);
    }
}
