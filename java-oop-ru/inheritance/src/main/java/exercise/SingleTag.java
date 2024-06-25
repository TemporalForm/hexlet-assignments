package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        String openingTag = String.format("<%s", super.getTag());
        String attributes = super.getAttributes()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.format("=\"%s\"", entry.getValue()))
                .collect(Collectors.joining(" "));
        String closingSymbol = ">";
        return openingTag
                + (attributes.isEmpty() ? "" : " " + attributes)
                + closingSymbol;
    }
}
// END
