package solutions.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class N20N32Parentheses {

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

    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right >= left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left >= right) {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }

    public static int longestValidParenthesesStack(String s) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(N20N32Parentheses.isValid("({({})([])})"));
        System.out.println(N20N32Parentheses.isValid("]"));
        System.out.println(N20N32Parentheses.longestValidParentheses("())(())"));
        System.out.println(N20N32Parentheses.longestValidParentheses(")()())"));
        System.out.println(N20N32Parentheses.longestValidParenthesesStack("())(())"));
        System.out.println(N20N32Parentheses.longestValidParenthesesStack(")()())"));
    }
}
