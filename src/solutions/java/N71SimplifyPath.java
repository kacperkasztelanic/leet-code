package solutions.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class N71SimplifyPath {

    public static String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : tokens) {
            if (!s.isEmpty() && !s.equals(".")) {
                if ("..".equals(s)) {
                    if (!deque.isEmpty()) {
                        deque.pollLast();
                    }
                }
                else {
                    deque.offerLast(s);
                }
            }
        }
        return "/" + String.join("/", deque);
    }

    public static void main(String[] args) {
        assert simplifyPath("/home/").equals("/home");
        assert simplifyPath("/../").equals("/");
        assert simplifyPath("/home//foo/").equals("/home/foo");
        assert simplifyPath("/a/../../b/../c//.//").equals("/c");
        assert simplifyPath("/a//b////c/d//././/../").equals("/a/b/c");
    }
}
