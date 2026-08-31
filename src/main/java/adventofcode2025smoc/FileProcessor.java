package adventofcode2025smoc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class FileProcessor {
    public Stream<String> readLines(String resourceName) {
        try {
            ClassLoader loader = getClass().getClassLoader();
            InputStream inputStream = loader.getResourceAsStream(resourceName);

            if (inputStream == null) {
                throw new IllegalArgumentException("Archivo no encontrado en resources: " + resourceName);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }
    }
}
