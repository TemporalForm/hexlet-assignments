package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.write(path,
                    car.serialize().getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            String carJson = String.join("", lines);
            return Car.unserialize(carJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
