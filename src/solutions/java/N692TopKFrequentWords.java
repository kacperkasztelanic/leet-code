package solutions.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N692TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Comparator<String> comparator = Comparator.comparingInt((String v) -> map.get(v).intValue()).reversed()//
                .thenComparing(Comparator.naturalOrder());
        Queue<String> queue = new PriorityQueue<>(comparator);
        map.keySet().forEach(queue::offer);
        return Stream.generate(queue::poll)//
                .limit(k)//
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        assert topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2)
                .equals(Arrays.asList("i", "love"));
        assert topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4)
                .equals(Arrays.asList("the", "is", "sunny", "day"));
    }
}
