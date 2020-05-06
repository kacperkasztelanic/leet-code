package solutions.java;

public class N674LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            }
            else {
                curr = 1;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    public static void main(String[] args) {
        N674LongestContinuousIncreasingSubsequence app = new N674LongestContinuousIncreasingSubsequence();
        assert app.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }) == 3;
        assert app.findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }) == 1;
        assert app.findLengthOfLCIS(new int[] {}) == 0;
    }
}
