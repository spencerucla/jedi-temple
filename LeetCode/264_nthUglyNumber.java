class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.add(1l);
        for (int i = 1; i < n; i++) {
            long curr = heap.poll();
            if (!heap.contains(curr * 2))
                heap.add(curr * 2);
            if (!heap.contains(curr * 3))
                heap.add(curr * 3);
            if (!heap.contains(curr * 5))
                heap.add(curr * 5);
        }
        return heap.peek().intValue();
    }
}
