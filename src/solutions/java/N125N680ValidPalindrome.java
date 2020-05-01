package solutions.java;

public class N125N680ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j)) //
                    && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars().filter(Character::isLetterOrDigit).map(Character::toLowerCase).forEach(c -> builder.append((char) c));
        return builder.toString().equals(builder.reverse().toString());
    }

    public static boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s.substring(i + 1, j + 1)) || checkPalindrome(s.substring(i, j));
            }
        }
        return true;
    }

    private static boolean checkPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assert isPalindrome2("A man, a plan, a canal: Panama");
        assert !isPalindrome2("race a car");
        assert validPalindrome("aba");
        assert validPalindrome("abca");
        assert validPalindrome("deeee");
        assert !validPalindrome("abc");
    }
}
