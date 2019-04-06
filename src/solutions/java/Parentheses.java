package solutions.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class Parentheses {

    private static final Set<Character> OPENING = Set.of('(', '[', '{');
    private static final Map<Character, Character> EQUIVALENCES = Map.of(')', '(', ']', '[', '}', '{');

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length() / 2);
        for (char c : s.toCharArray()) {
            if (OPENING.contains(c)) {
                stack.push(c);
            } else {
                if (EQUIVALENCES.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(Parentheses.isValid("({({})([])})"));
        System.out.println(Parentheses.isValid("]"));
    }
}
