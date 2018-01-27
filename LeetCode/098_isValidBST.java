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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return inorder(root, Long.MIN_VALUE) != Long.MAX_VALUE;
    }

    private long inorder(TreeNode node, long prev) {
        if (node.left != null)
            prev = inorder(node.left, prev);
        if (prev >= node.val)
            return Long.MAX_VALUE;
        prev = node.val;
        if (node.right != null)
            prev = inorder(node.right, prev);
        return prev;
    }
}
