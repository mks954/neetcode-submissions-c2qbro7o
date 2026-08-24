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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty()){
            int size = q1.size();
            if(size != q2.size()){
                return false;
            }
            for(int i = 0 ; i < size ; i++){
                TreeNode a = q1.poll();
                TreeNode b = q2.poll();

                if(a==null && b == null){
                    continue;
                }
                if(a==null || b == null || a.val != b.val){
                    return false;
                }
                q1.offer(a.left);
                q1.offer(a.right);
                q2.offer(b.left);
                q2.offer(b.right);
            }
        }

        return true;        
    }
}
