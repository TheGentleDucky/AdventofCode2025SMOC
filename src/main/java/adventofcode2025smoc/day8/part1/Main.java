package adventofcode2025smoc.day8.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day8.common.Connection;
import adventofcode2025smoc.day8.common.ConnectionFinder;
import adventofcode2025smoc.day8.common.JunctionBox;
import adventofcode2025smoc.day8.common.JunctionBoxParser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final int FinalConnections = 1000;

    public static void main(String[] args) {
        FileProcessor fp = new FileProcessor();
        JunctionBoxParser jbp = new JunctionBoxParser();
        ConnectionFinder cf = new ConnectionFinder();

        try (Stream<String> lines = fp.readLines("D8_Input.txt")) {
            List<JunctionBox> boxes = jbp.parseJunctionBox(lines);
            List<Connection> connections = cf.findAllConnections(boxes);
            CircuitManager circuitManager = new CircuitManager(boxes);

            for (int i = 0; i < FinalConnections; i++) {
                Connection connection = connections.get(i);

                circuitManager.connect(connection.first(), connection.second());
            }

            List<Integer> circuitSizes = circuitManager.getSizes();

            circuitSizes.sort(Comparator.reverseOrder());

            long result =(long) circuitSizes.get(0) * circuitSizes.get(1) * circuitSizes.get(2);

            System.out.println(result);
        }
    }
}
