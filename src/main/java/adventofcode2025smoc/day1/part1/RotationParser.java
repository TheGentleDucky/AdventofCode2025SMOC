package adventofcode2025smoc.day1.part1;

public class RotationParser {

    public Rotation parse(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("Error de lectura en la línea: " + line);
        }

        char dirChar = line.charAt(0);
        int clicks = Integer.parseInt(line.substring(1).trim());

        Rotation.Direction direction = switch (dirChar) {
            case 'L' -> Rotation.Direction.LEFT;
            case 'R' -> Rotation.Direction.RIGHT;
            default -> throw new IllegalArgumentException("Dirección desconocida: " + dirChar);
        };
        return new Rotation(direction, clicks);
    }
}