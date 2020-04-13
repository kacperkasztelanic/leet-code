package solutions.java;

public class N7ReverseInteger {

    public static int reverse(int input) {
        int rev = 0;
        int x = input;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (isOverflow(rev, pop)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    private static boolean isOverflow(int rev, int pop) {
        if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
            return true;
        }
        return rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8);
    }

    public static void main(String[] args) {
        assert reverse(1534236469) == 0;
    }
}
