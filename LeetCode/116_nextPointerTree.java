/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            Node curr = queue.poll();
            Node next = queue.peek();
            if (curr != null) {
                curr.next = next;
                if (curr.left != null) { // parent
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            } else {
                if (next != null) // handle root = null case
                    queue.add(null);
            }
        }
        return root;
    }
}
