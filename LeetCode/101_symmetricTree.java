/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode t) {
        if (t == null) {
            return true;
        }
        return areTreesSymmetric(t.left, t.right);
    }

    boolean areTreesSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return areTreesSymmetric(t1.left, t2.right)
                && areTreesSymmetric(t1.right, t2.left);
    }
}
