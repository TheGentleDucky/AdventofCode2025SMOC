package adventofcode2025smoc.day1.part2;

public class Dial {
    private static final int MAX_VALUE = 100;
    private int position;

    public Dial(int initialPosition) {

        this.position = initialPosition;
    }

    public int turnLeft(int clicks) {
        position = (position - clicks) % MAX_VALUE;
        if (position < 0) {
            position = position +- MAX_VALUE;
        }
        return position;
    }

    public int turnRight(int clicks) {
        position = (position + clicks) % MAX_VALUE;
        return position;
    }

    public int getPosition(){
        return position;
    }
}
