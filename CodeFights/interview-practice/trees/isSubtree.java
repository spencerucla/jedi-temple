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
boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null)
        return true;
    if (t1 == null)
        return false;
    if (equals(t1, t2))
        return true;
    return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
}

boolean equals(Tree<Integer> t1, Tree<Integer> t2) {
    if (t1 == null && t2 == null)
        return true;
    if (t1 == null || t2 == null)
        return false;
    if (!t1.value.equals(t2.value))
        return false;
    return equals(t1.left, t2.left) && equals(t1.right, t2.right);
}
