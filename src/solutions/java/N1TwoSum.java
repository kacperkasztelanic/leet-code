package solutions.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        assert Arrays.equals(twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
    }
}
