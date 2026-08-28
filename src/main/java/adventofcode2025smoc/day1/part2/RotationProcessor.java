package adventofcode2025smoc.day1.part2;

import java.util.List;

public class RotationProcessor {

    public int countZeros(Dial dial, List<Rotation> rotations) {
        int zeroCount = 0;


        for (Rotation rotation : rotations) {
            int clicks = rotation.getClicks();

            for (int i = 0; i < clicks; i++) {
                int newPosition = rotateOnce(dial, rotation.getDirection());

                if (newPosition == 0) {
                    zeroCount++;
                }
            }
        }

        return zeroCount;
    }

    private int rotateOnce(Dial dial, Rotation.Direction direction) {
        return switch (direction) {
            case LEFT -> dial.turnLeft(1);
            case RIGHT -> dial.turnRight(1);
        };
    }
}