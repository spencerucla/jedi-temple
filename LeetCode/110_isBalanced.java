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
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        // propagate imbalance upwards
        if (Math.abs(l-r) > 1 || l == -1 || r == -1)
            return -1;
        return 1 + Math.max(l, r);
    }
}
