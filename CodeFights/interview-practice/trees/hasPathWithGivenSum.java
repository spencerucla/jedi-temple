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
boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    // stub so t == null can use below base case
    if (t == null) {
        t = new Tree(0);
    }
    if (t.left == null && t.right == null) {
        if (s == t.value) {
            return true;
        } else {
            return false;
        }
    }
    boolean ret = false;
    if (t.left != null) {
        ret |= hasPathWithGivenSum(t.left, s - t.value);
    }
    // TODO: could be more efficient by short circuiting right
    if (t.right != null) {
        ret |= hasPathWithGivenSum(t.right, s - t.value);
    }
    return ret;
}

