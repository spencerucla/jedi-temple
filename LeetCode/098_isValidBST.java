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
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        // System.out.println(nums);
        int prev = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (prev >= nums.get(i))
                return false;
            prev = nums.get(i);
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> nums) {
        if (node.left != null)
            inorder(node.left, nums);
        nums.add(node.val);
        if (node.right != null)
            inorder(node.right, nums);
    }
}
