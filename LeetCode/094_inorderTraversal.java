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
        return inorderTraversalIter(root);
        // return inorderTraversalRec(root);
    }

    public List<Integer> inorderTraversalRec(TreeNode root) {
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

    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            values.add(root.val);
            root = root.right;
        }
        return values;
    }
}
