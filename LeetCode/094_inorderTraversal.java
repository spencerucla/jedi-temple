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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        traverseInOrder(root, ret);
        return ret;
    }

    private void traverseInOrder(TreeNode node, List<Integer> ret) {
        if (node == null)
            return;
        traverseInOrder(node.left, ret);
        ret.add(node.val);
        traverseInOrder(node.right, ret);
    }
}
