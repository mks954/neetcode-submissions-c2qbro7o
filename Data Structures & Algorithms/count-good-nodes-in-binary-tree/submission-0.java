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
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode node, int mval){
        if(node == null){
            return;
        }

        if(node.val>=mval){
            res++;
            mval = node.val;
        }

        dfs(node.left, mval);
        dfs(node.right, mval);
    }
}
