//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] largestValuesInTreeRows(Tree<Integer> t) {
    Queue<Tree<Integer>> q = new LinkedList<Tree<Integer>>();
    List<Integer> nums = new ArrayList<Integer>();
    if (t != null) {
        q.add(t);
        q.add(null);
    }
    int curMax = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
        Tree<Integer> curr = q.remove();
        if (curr == null) { // use null to denote end of row
            if (!q.isEmpty()) // don't re-add null if we're done
                q.add(null);
            nums.add(curMax);
            curMax = Integer.MIN_VALUE;
        } else {
            if (curr.value > curMax)
                curMax = curr.value;
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }
    int[] maxes = new int[nums.size()];
    for (int i = 0; i < nums.size(); i++) {
        maxes[i] = nums.get(i);
    }
    return maxes;
}

