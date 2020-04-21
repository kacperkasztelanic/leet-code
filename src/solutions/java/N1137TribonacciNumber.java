package solutions.java;

public class N1137TribonacciNumber {

    public static int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n; i++) {
            int temp1 = a;
            int temp2 = b;
            a = b;
            b = c;
            c = temp1 + temp2 + c;
        }
        return a;
    }

    public static void main(String[] args) {
        assert tribonacci(4) == 4;
        assert tribonacci(25) == 1389537;
        assert tribonacci(37) == 2082876103;
    }
}
