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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(Integer.MIN_VALUE, head);
        head = prev;
        boolean deleteP = false;
        while (prev.next != null || deleteP) {
            if (prev.next.next != null && prev.next.val == prev.next.next.val) {
                prev.next.next = prev.next.next.next;
                deleteP = true;
            } else if (deleteP) {
                prev.next = prev.next.next;
                deleteP = false;
            } else {
                prev = prev.next;
            }
        }
        return head.next;
    }
}
