package adventofcode2025smoc.day8.part2;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day8.common.Connection;
import adventofcode2025smoc.day8.common.ConnectionFinder;
import adventofcode2025smoc.day8.common.JunctionBox;
import adventofcode2025smoc.day8.common.JunctionBoxParser;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main() {
        FileProcessor fileProcessor = new FileProcessor();
        JunctionBoxParser junctionBoxParser = new JunctionBoxParser();
        ConnectionFinder connectionFinder = new ConnectionFinder();

        try (Stream<String> lines = fileProcessor.readLines("D8_Input.txt")) {
            List<JunctionBox> junctionBoxes = junctionBoxParser.parseJunctionBox(lines);
            List<Connection> connections = connectionFinder.findAllConnections(junctionBoxes);
            CircuitManager circuitManager = new CircuitManager(junctionBoxes);

            for (Connection connection : connections) {
                circuitManager.connect(connection.first(), connection.second());

                if (circuitManager.isSingle()){
                    long result = connection.first().x() * connection.second().x();
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
