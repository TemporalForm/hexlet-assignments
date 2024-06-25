package exercise;

import javax.swing.text.html.HTML;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String tag;
    private Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public abstract String toString();

    public String getTag() {
        return tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

}
// END
