class Solution {
    private int ans = 0;

    private int d(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = 1 + d(root.left);
        int right = 1 + d(root.right);

        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        d(root);
        return ans;
    }
}