package adventofcode2025smoc.day8.common;

public record JunctionBox(long x, long y, long z) {
    public long squareDistance(JunctionBox box) {
        long dx = this.x - box.x;
        long dy = this.y - box.y;
        long dz = this.z - box.z;

        return dx * dx + dy * dy + dz * dz;
    }
}
