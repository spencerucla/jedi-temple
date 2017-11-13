int kthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);
        }
    });
    for (int num : nums) {
            heap.add(num);
    }
    int elem = 0;
    for (int i = 0; i < k; i++) {
        elem = heap.poll();
    }
    return elem;
}
