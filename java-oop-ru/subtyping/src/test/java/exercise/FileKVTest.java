package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void serializeTest() {
        KeyValueStorage dictionary = new FileKV(filepath.toString(), Map.of("key", "value"));
        Utils.writeFile(filepath.toString(), Utils.serialize(dictionary.toMap()));
        String actual = Utils.readFile("src/test/resources/test-file-contents.txt");
        String expected = Utils.readFile(filepath.toString());
        assertThat(expected).isEqualTo(actual);
    }


    @Test
    public void deserializeTest() {
        KeyValueStorage dictionary = new FileKV(filepath.toString(), Map.of("key", "value"));
        Utils.writeFile(filepath.toString(), Utils.serialize(dictionary.toMap()));
        String jsonDictionary = Utils.readFile(filepath.toString());
        Map<String, String> actual = Utils.unserialize(jsonDictionary);
        Map<String, String> expected = dictionary.toMap();
        assertThat(expected).isEqualTo(actual);
    }
    // END
}
