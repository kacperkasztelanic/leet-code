package solutions.java;

public class N509FibonacciNumber {

    public static int fib(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a;
    }

    public static void main(String[] args) {
        assert fib(2) == 1;
        assert fib(3) == 2;
        assert fib(4) == 3;
    }
}
