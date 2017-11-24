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
int[] traverseTree(Tree<Integer> t) {
    Queue<Tree<Integer>> q = new LinkedList<Tree<Integer>>();
    List<Integer> nums = new ArrayList<Integer>();
    if (t != null)
        q.add(t);
    while (!q.isEmpty()) {
        Tree<Integer> curr = q.remove();
        nums.add(curr.value);
        if (curr.left != null)
            q.add(curr.left);
        if (curr.right != null)
            q.add(curr.right);
    }
    int[] arr = new int[nums.size()];
    for (int j = 0; j < nums.size(); j++) {
        arr[j] = nums.get(j);
    }
    return arr;
}

