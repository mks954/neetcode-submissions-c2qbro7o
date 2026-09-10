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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        int pivot = -1;

        for(int i = 0 ; i < inorder.length ; i++){
            if(preorder[0]==inorder[i]){
                pivot = i;
            }
        }

        int[] leftpre = Arrays.copyOfRange(preorder, 1, pivot+1);
        int[] leftino = Arrays.copyOfRange(inorder, 0, pivot);

        root.left = buildTree(leftpre, leftino);

        int[] rightpre = Arrays.copyOfRange(preorder, 1+pivot, preorder.length);
        int[] rightino = Arrays.copyOfRange(inorder, 1+pivot, inorder.length);

        root.right = buildTree(rightpre, rightino);

        return root;
    }
}
