package adventofcode2025smoc.day1.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PasswordSolver {
    private final RotationParser parser = new RotationParser();

    public int solve(String inputName) throws IOException {
        List<Rotation> rotations = loadRotations(inputName);

        Dial dial = new Dial(50);
        RotationProcessor processor = new RotationProcessor();

        return processor.countZeros(dial, rotations);
    }

    private List<Rotation> loadRotations(String inputName) throws IOException {
        List<Rotation> rotations = new ArrayList();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputName);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + inputName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rotations.add(parser.parse(line));
            }
        }

        return rotations;
    }
}