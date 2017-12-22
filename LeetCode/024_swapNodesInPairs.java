/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            ListNode after = prev.next.next.next;

            prev.next = second;
            second.next = first;
            first.next = after;

            prev = first;
        }

        return head.next;
    }
}
