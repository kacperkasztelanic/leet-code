package solutions.java;

public class N917ReverseOnlyLetters {

    public static String reverseOnlyLetters(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (isLetter(chars[i]) && isLetter(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            if (!isLetter(chars[i])) {
                i++;
            }
            if (!isLetter(chars[j])) {
                j--;
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isLetter(char input) {
        return 'a' <= input && input <= 'z' || 'A' <= input && input <= 'Z';
    }

    public static void main(String[] args) {
        assert reverseOnlyLetters("ab-cd").equals("dc-ba");
        assert reverseOnlyLetters("a-bC-dEf-ghIj").equals("j-Ih-gfE-dCba");
        assert reverseOnlyLetters("Test1ng-Leet=code-Q!").equals("Qedo1ct-eeLg=ntse-T!");
    }
}
