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
boolean isTreeSymmetric(Tree<Integer> t) {
    if (t == null) {
        return true;
    }
    return areTreesSymmetric(t.left, t.right);
}

boolean areTreesSymmetric(Tree<Integer> t1, Tree<Integer> t2) {
    if (t1 == null && t2 == null) {
        return true;
    } else if (t1 == null && t2 != null) {
        return false;
    } else if (t1 != null && t2 == null) {
        return false;
    }
    if (!t1.value.equals(t2.value)) {
        return false;
    }
    return areTreesSymmetric(t1.left, t2.right)
            && areTreesSymmetric(t1.right, t2.left);
}
