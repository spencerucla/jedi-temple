import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {
    private Deque<> stack = new ArrayDeque<Integer>();
    private Deque<> maxes = new ArrayDeque<Integer>();

    public int getMax() {
        return maxes.peek();
    }

    public void push(int val) {
        stack.push(val);
        if (maxes.isEmpty() || val >= maxes.peek()) {
            maxes.push(val);
        }
    }

    public int pop() {
        int val = stack.pop();
        if (val == maxes.peek()) {
            maxes.pop();
        }
        return val;
    }
}
