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
    private String serialize(TreeNode root){
        if(root == null){
            return "$#";
        }
        return "$" + root.val + serialize(root.left) + serialize(root.right);
        // preorder dfs
    }  

    private int[] z_function(String s){
        int n = s.length();
        int[] z = new int[n];

        for(int i = 1; i < s.length(); i++){
            while(i+z[i]<n && s.charAt(z[i]) == s.charAt(i+z[i])){
                z[i]++;
            }   
        }

        return z;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s1 = serialize(root);
        String s2 = serialize(subRoot);

        String s = s2 + '|' + s1;

        int[] z = z_function(s);

        for(int i = s2.length()+1; i<s.length(); i++){
            if(z[i] == s2.length()){
                return true;
            }
        }
        return false;
    }
}
