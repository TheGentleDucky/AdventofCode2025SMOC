package adventofcode2025smoc.day1.part1;

import java.util.List;

public class RotationProcessor {

    public int countZeros(Dial dial, List<Rotation> rotations) {
        int zeroCount = 0;

        for (Rotation rotation: rotations) {
            int newPosition = switch (rotation.getDirection()) {
                case LEFT -> dial.turnLeft(rotation.getClicks());
                case RIGHT -> dial.turnRight(rotation.getClicks());
            };

            if (newPosition == 0) {
                zeroCount++;
            }
        }
        return zeroCount;
    }
}