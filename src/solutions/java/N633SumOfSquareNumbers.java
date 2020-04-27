package solutions.java;

public class N633SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c) + 1;
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        assert !judgeSquareSum(2147483646);
        assert !judgeSquareSum(999999999);
        assert judgeSquareSum(0);
        assert judgeSquareSum(2);
        assert judgeSquareSum(5);
        assert judgeSquareSum(4);
        assert !judgeSquareSum(7);
        assert !judgeSquareSum(3);

    }
}
