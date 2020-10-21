package solutions.java;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

public class N242ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        Function<String, Map<Integer, Long>> fun =
                a -> a.chars().boxed().collect(Collectors.groupingBy(identity(), counting()));
        return fun.apply(s).equals(fun.apply(t));
    }

    public static void main(String[] args) {
        assert isAnagram("anagram", "nagaram");
        assert !isAnagram("rat", "car");
    }
}
