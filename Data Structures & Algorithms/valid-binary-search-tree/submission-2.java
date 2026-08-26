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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int minval, int maxval){
        if(node == null){
            return true;
        }

        if(node.val <= minval || node.val >= maxval){
            return false;
        }

        boolean left = dfs(node.left, minval, node.val);
        boolean right = dfs(node.right, node.val , maxval);

        return left && right;
    }
}
