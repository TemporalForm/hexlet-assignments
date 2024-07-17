package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

// BEGIN
public class App {

    public static void save(Path filePath, Car instance) throws Exception {
        String jsonRepresentation = instance.serialize();
        Files.writeString(filePath, jsonRepresentation, StandardOpenOption.WRITE);
    }

    public static Car extract(Path filePath) throws Exception {
        String jsonRepresentation = Files.readString(filePath);
        Car instance = Car.unserialize(jsonRepresentation);
        return instance;
    }
}
// END
