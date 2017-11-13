// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    if (l == null) {
        return true;
    }

    ListNode<Integer> slow = l, fast = l, prev_slow = l;
    ListNode<Integer> mid = null, secondHalf;
    boolean ret = true;
    while (fast != null && fast.next != null) {
        prev_slow = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    if (fast != null) { // odd
        secondHalf = slow.next;
        mid = prev_slow.next;
        prev_slow.next = null;
    } else { // even
        secondHalf = prev_slow.next;
        prev_slow.next = null;
    }

    secondHalf = reverse(secondHalf);

    slow = secondHalf; // reuse slow to traverse secondHalf
    fast = l; // reuse fast to traverse first half (l)
    while (slow != null && fast != null) {
        if (!slow.value.equals(fast.value)) {
            ret = false;
        }
        slow = slow.next;
        fast = fast.next;
    }

    // fix the list
    if (mid != null) {
        prev_slow.next = mid;
        prev_slow = mid;
    }
    prev_slow.next = reverse(secondHalf);

    return ret;
}

ListNode<Integer> reverse(ListNode<Integer> curr) {
    ListNode<Integer> prev = null, next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

// unused, recursive doesn't work for big n
ListNode<Integer> reverseRec(ListNode<Integer> l) {
    if (l == null) {
        return null;
    }

    ListNode<Integer> rest = reverse(l.next);
    if (rest == null) {
        return l;
    }

    l.next.next = l;
    l.next = null;
    return rest;
}
