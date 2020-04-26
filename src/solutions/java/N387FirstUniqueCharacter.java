package solutions.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;

public class N387FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Long> countByChar = s.chars()//
                .mapToObj(i -> (char) i)//
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
        return IntStream.range(0, s.length())//
                .filter(i -> countByChar.get(s.charAt(i)).equals(1L))//
                .findFirst()//
                .orElse(-1);
    }
}
