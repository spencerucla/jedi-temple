class MinStack1 {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        // store prev min within stack
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if top was min, pop again to get prev min
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack2 {
    private static class Node {
        int val;
        int min;
        Node next;
        Node(int x, int y, Node z) { val = x; min = y; next = z; }
    }
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        head = new Node(x, Math.min(x, head != null ? head.min : Integer.MAX_VALUE), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
