package solutions.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N118N119PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>(i);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = Collections.singletonList(1);
        List<Integer> curr = prev;
        for (int i = 1; i <= rowIndex; i++) {
            curr = new ArrayList<>(i);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }
        return curr;
    }
}
