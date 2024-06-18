package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> bufferStorage = new HashMap<>(storage.toMap());
        bufferStorage.forEach((key, value) -> storage.unset(key));
        bufferStorage.forEach((key, value) -> storage.set(value, key));
    }
}
// END
