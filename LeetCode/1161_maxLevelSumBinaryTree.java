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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        int currentLevel = 1, currentSum = 0;
        int maxLevel = currentLevel, maxSum = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                currentSum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            } else {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxLevel = currentLevel;
                }
                currentSum = 0;
                currentLevel++;
                if (!q.isEmpty()) q.offer(null);
            }
        }
        return maxLevel;
    }
}
