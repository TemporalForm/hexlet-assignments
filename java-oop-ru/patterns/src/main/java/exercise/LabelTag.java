package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String label;
    private TagInterface inputTag;

    public LabelTag(String label, TagInterface inputTag) {
        this.label = label;
        this.inputTag = inputTag;
    }

    public String render() {
        return "<label>" + label + inputTag.render() + "</label>";
    }
}
// END
