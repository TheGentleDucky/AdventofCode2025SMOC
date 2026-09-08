package adventofcode2025smoc.day8.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConnectionFinder {
    public List<Connection> findAllConnections(List<JunctionBox> junctionBoxes) {
        List<Connection> connections = new ArrayList<>();

        for(int first = 0; first < junctionBoxes.size(); first++){
            //Second = first +1 porque no queremos conexiones identicas. RECUERDA!!!
            for(int second = first+1; second < junctionBoxes.size(); second++){
                connections.add(Connection.getConnection(junctionBoxes.get(first), junctionBoxes.get(second)));

            }
        }
        return connections.stream().sorted(Comparator.comparingLong(Connection::squaredDistance)).toList();
    }
}
