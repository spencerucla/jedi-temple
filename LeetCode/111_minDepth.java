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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int ldepth = Integer.MAX_VALUE;
        int rdepth = Integer.MAX_VALUE;
        if (root.left != null)
            ldepth = minDepth(root.left);
        if (root.right != null)
            rdepth = minDepth(root.right);
        return 1 + Math.min(ldepth, rdepth);
    }
}
