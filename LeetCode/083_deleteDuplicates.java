/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head;
        for (ListNode next = head.next; next != null; next = next.next) {
            if (next.val != curr.val) {
                curr.next = next;
                curr = next;
            }
        }
        curr.next = null;
        return head;
    }
}
