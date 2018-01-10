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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return dfs("", root);
    }

    private int dfs(String prev, TreeNode curr) {
        if (curr.left == null && curr.right == null)
            return Integer.parseInt(prev + curr.val);
        int sum = 0;
        if (curr.left != null)
            sum += dfs(prev + curr.val, curr.left);
        if (curr.right != null)
            sum += dfs(prev + curr.val, curr.right);
        return sum;
    }
}
