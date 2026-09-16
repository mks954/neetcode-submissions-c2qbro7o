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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0 ; i < s ; i++){
                TreeNode curr = q.poll();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                curr.left = right;
                curr.right = left;
                if(right != null) q.offer(right);
                if(left != null) q.offer(left);
            }
        }
        return root;
    }
}
