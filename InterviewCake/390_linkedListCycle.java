public class Solution {
    private static class LinkedListNode {
        int val;
        LinkedListNode next;
        LinkedListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean contains_cycle(LinkedListNode node) {
        LinkedListNode slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.contains_cycle(null);
    }
}
