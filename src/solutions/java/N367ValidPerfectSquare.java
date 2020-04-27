package solutions.java;

public class N367ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num / 2;
        int mid = 1;
        while (low <= high && mid != num / mid) {
            mid = low + (high - low) / 2;
            if (mid > num / mid) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return mid * mid == num;
    }

    public static void main(String[] args) {
        assert isPerfectSquare(1);
        assert isPerfectSquare(4);
        assert !isPerfectSquare(14);
        assert isPerfectSquare(16);
        assert !isPerfectSquare(2147483647);
    }
}
