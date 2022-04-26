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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(0, head);
        head = prev;
        ListNode[] savedToReverse = new ListNode[k];
        boolean hasK = true;

        while (hasK) {
            // parse next k
            ListNode curr = prev.next;
            for (int i = k-1; i >= 0 && (hasK = (curr != null)); i--) {
                savedToReverse[i] = curr;
                curr = curr.next;
            }

            // if there were k, reverse n link em up
            if (hasK) {
                prev.next = savedToReverse[0];
                for (int i = 0; i < k-1; i++) {
                    savedToReverse[i].next = savedToReverse[i+1];
                }
                savedToReverse[k-1].next = curr;
                prev = savedToReverse[k-1];
            }
        }

        return head.next;
    }
}
