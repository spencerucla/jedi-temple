/**
 * // Reminder of some the useful methods of the TreeNode interface
 * public interface TreeNode {
 *     // Get all the children of a node
 *     Collection<TreeNode> children();
 * }
 */
class Solution {
    public List<Set<TreeNode>> fallingLeaves(TreeNode root) {
        List<Set<TreeNode>> list = new ArrayList<>();
        search(root, list);
    }

    private int search(TreeNode curr, List<Set<TreeNode>> list) {
        if (curr == null) {
            return 0;
        }

        int maxHeight = 0;
        for (TreeNode child : curr.children()) {
            maxHeight = Math.maxHeight(maxHeight, search(child, list));
        }

        if (list.size() <= maxHeight) {
            list.add(new HashSet<TreeNode>();
        }
        list.get(maxHeight).add(curr);
        return maxHeight + 1;
    }
}
