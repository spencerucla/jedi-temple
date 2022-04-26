/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0, head);
        head = prev;
        ListNode curr = prev.next;
        while (curr != null && curr.next != null) {
            ListNode tmp = curr.next.next;
            prev.next = curr.next;
            prev.next.next = curr;
            curr.next = tmp;

            prev = curr;
            curr = tmp;
        }
        return head.next;
    }
}
