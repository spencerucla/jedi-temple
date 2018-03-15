/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // split list
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode first  = sortList(head);
        ListNode second = sortList(midNext);
        return mergeTwoLists(first, second);
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }

        // 1 of the lists is empty, link up non-empty list to end of curr
        curr.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
