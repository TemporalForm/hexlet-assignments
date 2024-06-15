package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    @Test
    void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        String actual = text.toString();
        String expected = "fedcba";
        assertThat(actual).isEqualTo(expected);
    }
}
