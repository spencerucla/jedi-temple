/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;

		// question was unclear if make new node regardless of null on 1 side or use it
        TreeNode left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        TreeNode right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        TreeNode curr = new TreeNode(
                (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0), left, right);
        return curr;
    }
}
