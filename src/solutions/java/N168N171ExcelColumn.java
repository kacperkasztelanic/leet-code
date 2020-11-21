package solutions.java;

public class N168N171ExcelColumn {

    private static final int NUMBER_OF_LETTERS = 'Z' - 'A' + 1;
    private static final int LETTER_A = 'A';

    public int getIndex(String letters) {
        String normalized = letters != null ? letters.trim().toUpperCase() : "";
        if (normalized.isEmpty() || !normalized.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException(letters);
        }
        return normalized.chars().reduce(0, (r, c) -> r * NUMBER_OF_LETTERS + c - LETTER_A + 1);
    }

    public String getLetters(int index) {
        if (index < 1) {
            throw new IllegalArgumentException(String.valueOf(index));
        }
        StringBuilder res = new StringBuilder();
        int n = index;
        while (n > 0) {
            int remainder = (n - 1) % NUMBER_OF_LETTERS;
            n = (n - 1) / NUMBER_OF_LETTERS;
            res.append((char) (LETTER_A + remainder));
        }
        return res.reverse().toString();
    }
}
