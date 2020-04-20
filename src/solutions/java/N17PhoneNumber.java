package solutions.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class N17PhoneNumber {

    private final Map<Character, List<Character>> map = Map.ofEntries(//
            Map.entry('2', "ABC"),//
            Map.entry('3', "DEF"),//
            Map.entry('4', "GHI"),//
            Map.entry('5', "JKL"),//
            Map.entry('6', "MNO"),//
            Map.entry('7', "PQRS"),//
            Map.entry('8', "TUV"),//
            Map.entry('9', "WXYZ")//
    ).entrySet().stream()//
            .collect(Collectors.toMap(//
                    Map.Entry::getKey,//
                    e -> e.getValue()//
                            .toLowerCase()//
                            .chars()//
                            .mapToObj(i -> (char) i)//
                            .collect(Collectors.toList())//
                    )//
            );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        return letterCombinations(0, digits.toCharArray(), List.of(""));
    }

    private List<String> letterCombinations(int index, char[] digits, List<String> list) {
        if (index < digits.length) {
            return letterCombinations(index + 1, digits, expand(list, map.get(digits[index])));
        }
        return list;
    }

    private static List<String> expand(List<String> list, List<Character> letters) {
        return list.stream()//
                .flatMap(s -> letters.stream().map(l -> s + l))//
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        N17PhoneNumber app = new N17PhoneNumber();
        assert app.letterCombinations("").equals(Collections.emptyList());
        assert new HashSet<>(app.letterCombinations("23"))
                .equals(new HashSet<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }
}
