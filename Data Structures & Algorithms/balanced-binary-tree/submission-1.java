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
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = 1 + depth(root.left);
        int right = 1 + depth(root.right);

        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean lef = isBalanced(root.left);
        boolean righ = isBalanced(root.right);

        if(lef==false || righ == false){
            return false;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if(Math.abs(left-right)<=1){
            return true;
        }

        return false;
    }
}
