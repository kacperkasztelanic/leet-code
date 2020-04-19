package solutions.java;

public class N191N693Bits {

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static boolean hasAlternatingBits(int n) {
        return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);
    }

    public static void main(String[] args) {
        assert hammingWeight(11) == 3;
        assert hammingWeight(128) == 1;
        assert hammingWeight(0xFFFFFFFD) == 31;

        assert hasAlternatingBits(5);
        assert !hasAlternatingBits(7);
        assert !hasAlternatingBits(11);
        assert hasAlternatingBits(10);
    }
}
