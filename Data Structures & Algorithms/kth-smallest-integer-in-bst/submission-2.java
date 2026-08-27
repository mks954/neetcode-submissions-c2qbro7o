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
    private int cnt = 0;
    private int check = 0;
    private int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        check = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        cnt++;
        if(cnt==check){
            ans = root.val;
            return;
        }else if(cnt > check){
            return;
        }
        dfs(root.right);
    }
}
