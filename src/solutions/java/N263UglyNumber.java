package solutions.java;

import java.util.stream.Stream;

public class N263UglyNumber {

    public static boolean isUgly(int n) {
        return n > 0 && (n == 1 || Stream.of(2, 3, 5).anyMatch(x -> n % x == 0 && isUgly(n / x)));
    }

    public static void main(String[] args) {
        System.out.println(isUgly(10));
    }
}
