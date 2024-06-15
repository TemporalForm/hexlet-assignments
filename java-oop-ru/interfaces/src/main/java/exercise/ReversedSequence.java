package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    String text;
    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.substring(start, end);
    }

    @Override
    public String toString() {
        StringBuilder reversedCharSequence = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            String currentLetter = String.valueOf(text.charAt(i));
            reversedCharSequence.append(currentLetter);
        }
        return String.valueOf(reversedCharSequence);
    }
}
// END
