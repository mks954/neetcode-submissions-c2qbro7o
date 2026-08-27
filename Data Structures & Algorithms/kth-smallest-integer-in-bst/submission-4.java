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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(curr);
        ArrayList<TreeNode> arr = new ArrayList<>(); 
        while(curr != null || !st.isEmpty()){
            while(curr != null && curr.left != null){
                st.push(curr.left);
                curr = curr.left;
            }
            curr = st.pop();
            arr.add(curr);
            if(arr.size()==k){
                return arr.get(k-1).val;
            }
            if(curr.right != null){
                curr = curr.right;
                st.push(curr);
            }else{
                curr = null;
            }
            
        }
        return -1;
    }
}
