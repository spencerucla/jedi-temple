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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        queue.add(root);
        queue.add(null);
        boolean zig = true;
        while (queue.size() > 1) { // queue always has 1 null @ end
            TreeNode curr = queue.poll();
            if (curr != null) {
                if (zig)
                    level.add(curr.val);
                else
                    level.add(0, curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            } else { // end of level
                zig = !zig;
                queue.add(null);
                ret.add(level);
                level = new ArrayList<Integer>();
            }
        }
        ret.add(level);
        return ret;
    }
}
