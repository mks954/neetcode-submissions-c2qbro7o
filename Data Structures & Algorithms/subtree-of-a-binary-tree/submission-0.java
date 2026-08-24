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
    private boolean issame(TreeNode root, TreeNode subroot){
        if(root == null && subroot == null){
            return true;
        }
        if(root == null || subroot == null || root.val != subroot.val){
            return false;
        }

        boolean left = issame(root.left, subroot.left);
        boolean right = issame(root.right, subroot.right);

        if(left == false || right == false){
            return false;
        }

        return true;
    }  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }else if(root == null){
            return false;
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        if(root.val==subRoot.val){
            if(issame(root, subRoot)){
                return true;
            }
        }

        if(left == true || right == true){
            return true;
        }

        return false;
    }
}
