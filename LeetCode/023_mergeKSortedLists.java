/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, listNodeComparator);
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            curr.next = next;
            curr = next;
            if (next.next != null) {
                heap.add(next.next);
            }
        }
        return head.next;
    }
}
