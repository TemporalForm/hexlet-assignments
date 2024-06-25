package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> singleTags;

    public PairedTag(String tag,
                     Map<String, String> attributes,
                     String tagBody,
                     List<Tag> singleTags) {
        super(tag, attributes);
        this.tagBody = tagBody;
        this.singleTags = singleTags;
    }

    @Override
    public String toString() {
        String openingTag = String.format("<%s", super.getTag());
        String attributes = super.getAttributes()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.format("=\"%s\"", entry.getValue()))
                .collect(Collectors.joining(" "));
        String closingTag = String.format("</%s>", super.getTag());
        String pairedTagBody = openingTag
                + (attributes.isEmpty() ? "" : " " + attributes)
                + ">";
        String resultTag = singleTags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""))
                + tagBody
                + closingTag;
        return pairedTagBody + resultTag;
    }
}
// END
