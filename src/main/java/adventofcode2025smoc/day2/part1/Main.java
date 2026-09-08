package adventofcode2025smoc.day2.part1;

import adventofcode2025smoc.day2.common.InvalidIDSum;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        InvalidIDFinder finder1 = new InvalidIDFinder();
        InvalidIDSum sum = new InvalidIDSum();

        try (InputStream input = Main.class.getResourceAsStream("/D2_Input.txt")) {
             if (input == null) {
                throw new IOException("No se pudo cargar el recurso.");
            }

            List<Long> invalidIDs = finder1.findInvalidIDs(input);

            long total = sum.sum(invalidIDs);

            System.out.println("Suma de Id's inválidos = " + total);

        } catch (IOException e) {
            System.err.println("Error en la lectura de Input.txt"+ e.getMessage());
        }
    }
}