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
int kthSmallestInBST(Tree<Integer> t, int k) {
    // Morris traversal
    // uncomment prints for in-order traversal
    while (t != null) {
        if (t.left == null) {
            // System.out.print(t.value + " ");
            if (k-- == 1) {
                return t.value;
            }
            t = t.right;
        } else {
            // Find the in-order predecessor of t
            Tree<Integer> pre = t.left;
            while (pre.right != null && pre.right != t) {
                pre = pre.right;
            }

            // Make t the right child of its in-order predecessor
            if (pre.right == null) {
                pre.right = t;
                t = t.left;
            } else {
                // fix tree (right child of predecessor)
                pre.right = null;
                // System.out.print(t.data + " ");
                if (k-- == 1) {
                    return t.value;
                }
                t = t.right;
            }
        }
    }
    return -1;
}

