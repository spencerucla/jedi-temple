public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean validBST(TreeNode root) {
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validBST(TreeNode node, int lo, int hi) {
        if (node == null) return true;
        if (node.val < lo || node.val > hi) return false;

        return validBST(node.left, lo, node.val) && validBST(node.right, node.val, hi);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root1 = new TreeNode(50,
            new TreeNode(17,
                new TreeNode(12,
                    new TreeNode(9),
                    new TreeNode(14)),
                new TreeNode(23,
                    new TreeNode(19),
                    null)),
            new TreeNode(72,
                new TreeNode(54,
                    null,
                    new TreeNode(67)),
                new TreeNode(76)));

        System.out.println(s.validBST(root1));

        TreeNode root2 = new TreeNode(55,
            new TreeNode(17,
                new TreeNode(12,
                    new TreeNode(9),
                    new TreeNode(14)),
                new TreeNode(23,
                    new TreeNode(19),
                    null)),
            new TreeNode(72,
                new TreeNode(54,
                    null,
                    new TreeNode(67)),
                new TreeNode(76)));

        System.out.println(s.validBST(root2));
    }
}
