package adventofcode2025smoc.day8.common;

public record Connection(JunctionBox first, JunctionBox second, long squaredDistance) {
    public static Connection getConnection(JunctionBox first, JunctionBox second) {
        return new Connection(first,second, first.squareDistance(second));

    }
}
