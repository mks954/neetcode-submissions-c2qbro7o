class Solution {
    private int ans = Integer.MIN_VALUE;
    private int max = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        max = Math.max(root.val, max);

        if (root.val >= 0) {
            int left = dfs(root.left);
            int right = dfs(root.right);

            ans = Math.max(ans, root.val + left + right);
            int returnValue;

            if (left > right) {
                returnValue = root.val + left;
            } else {
                returnValue = root.val + right;
            }

            return returnValue;
        }

        ans = Math.max(ans, root.val);

        int leftResult = dfs(root.left);
        int rightResult = dfs(root.right);

        // Best complete path passing through this node
        ans = Math.max(ans,
                root.val + leftResult + rightResult);

        // Best one-sided path that can be passed to parent
        return Math.max(Math.max(leftResult, rightResult) + root.val, 0);
    }

    public int maxPathSum(TreeNode root) {

        int temp = dfs(root);

        int result;

        if (max > 0) {
            result = Math.max(ans, temp);
        } else {
            result = max;
        }

 
        return result;
    }
}