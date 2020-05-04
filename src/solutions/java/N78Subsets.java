package solutions.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : res) {
                List<Integer> tmp = new ArrayList<>(curr);
                tmp.add(num);
                newSubsets.add(tmp);
            }
            res.addAll(newSubsets);
        }
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = (int) Math.pow(2, nums.length); i < (int) Math.pow(2, nums.length + 1.0); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            res.add(curr);
        }
        return res;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        return IntStream.range((int) Math.pow(2, nums.length), (int) Math.pow(2, nums.length + 1.0))//
                .mapToObj(i -> Integer.toBinaryString(i).substring(1))//
                .map(i -> IntStream.range(0, nums.length)//
                        .filter(j -> i.charAt(j) == '1')//
                        .map(j -> nums[j])//
                        .boxed()//
                        .collect(Collectors.toList())//
                )//
                .collect(Collectors.toList());
    }
}

