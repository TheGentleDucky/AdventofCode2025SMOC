package adventofcode2025smoc.day1.common;

public class Rotation {

    public enum Direction { LEFT, RIGHT }

    private final Direction direction;
    private final int clicks;

    public Rotation(Direction direction, int clicks) {
        this.direction = direction;
        this.clicks = clicks;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getClicks() {
        return clicks;
    }
}