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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ans.add(List.of(root.val));
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i< size ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                    temp.add(curr.left.val);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    temp.add(curr.right.val);
                }
            }
            if(temp.size() > 0){
                ans.add(temp);
            }
        }
        return ans;
    }
}
