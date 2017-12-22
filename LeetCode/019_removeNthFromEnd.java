/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode slow = ret;
        ListNode fast = ret;

        // move fast n+1 places ahead of slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // now move them at same pace until fast at end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return ret.next;
    }
}
