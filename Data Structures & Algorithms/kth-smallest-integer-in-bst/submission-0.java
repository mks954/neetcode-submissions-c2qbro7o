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
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        int ans = 0;
        for(int i = 0 ; i < k ; i++){
            if(i==k-1){
                ans = pq.poll();
            }
            pq.poll();
        }
        return ans;

    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);

        pq.offer(root.val);

    }
}
