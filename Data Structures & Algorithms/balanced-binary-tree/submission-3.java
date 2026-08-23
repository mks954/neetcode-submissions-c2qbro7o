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
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if(left[0]==0 || right [0]==0){
            return new int[]{0,0};
        }

        if(Math.abs(left[1]-right[1])<=1){
            int height = Math.max(left[1], right[1]);
            return new int[]{1, 1 + height};
        }

        left[0] = 0;
        return left;
    }
    public boolean isBalanced(TreeNode root) {
        int[] ans = dfs(root);
        return ans[0]==1?true:false;
    }
}
