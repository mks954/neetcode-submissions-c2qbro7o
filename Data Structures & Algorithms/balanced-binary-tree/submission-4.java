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
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root, last = null;
        HashMap<TreeNode, Integer> mp = new HashMap<>();

        while(!st.isEmpty() || node != null){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                node = st.peek();
                if(node.right == null || last == node.right){
                    st.pop();
                    int left = mp.getOrDefault(node.left, 0);
                    int right = mp.getOrDefault(node.right, 0);
                    int diff = Math.abs(left-right);
                    if(diff>1){
                        return false;
                    }
                    mp.put(node, Math.max(left, right)+1);
                    last = node;
                    node = null;

                }else{
                    node = node.right;
                }
            }
        }
        return true;
    }
}
