package solutions.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N165CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        Function<String, List<Integer>> parser = s -> Arrays.stream(s.split("\\."))//
                .map(Integer::parseInt)//
                .collect(Collectors.toList());
        BiFunction<List<Integer>, Integer, Integer> extractor = (l, i) -> i < l.size() ? l.get(i) : 0;
        List<Integer> v1 = parser.apply(version1);
        List<Integer> v2 = parser.apply(version2);
        int n = Math.max(v1.size(), v2.size());
        for (int i = 0; i < n; i++) {
            int cmp = extractor.apply(v1, i).compareTo(extractor.apply(v2, i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assert compareVersion("0.1", "1.1") == -1;
        assert compareVersion("1.0.1", "1") == 1;
        assert compareVersion("7.5.2.4", "7.5.3") == -1;
        assert compareVersion("1.01", "1.001") == 0;
        assert compareVersion("1.0", "1.0.0") == 0;
    }
}
