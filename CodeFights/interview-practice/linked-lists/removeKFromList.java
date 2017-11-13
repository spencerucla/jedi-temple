// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> head = new ListNode<Integer>(null);
    ListNode<Integer> prev = head;
    head.next = l;

    while (l != null) {
        if (l.value == k) {
            prev.next = l.next;
        } else {
            prev = l;
        }
        l = l.next;
    }
    return head.next;
}

