package solutions.java;

public class N234 {

    static class ListNode {
        int value;
        ListNode next;

        public static ListNode of(int value, ListNode next) {
            ListNode res = new ListNode();
            res.value = value;
            res.next = next;
            return res;
        }
    }

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }

    private boolean helper(ListNode right) {
        if (right == null) {
            return true;
        }
        if (helper(right.next)) {
            boolean y = left.value == right.value;
            left = left.next;
            return y;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(1, ListNode.of(2, null));
        ListNode l2 = ListNode.of(1, ListNode.of(2, ListNode.of(3, ListNode.of(2, ListNode.of(1, null)))));

        N234 s = new N234();
        System.out.println(s.isPalindrome(l1));
        System.out.println(s.isPalindrome(l2));
    }
}
