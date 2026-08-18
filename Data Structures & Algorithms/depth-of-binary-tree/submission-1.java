class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<ArrayList<TreeNode>> q = new ArrayList<>();

        // First level
        q.add(new ArrayList<>());
        q.get(0).add(root);

        for (int i = 0; i < q.size(); i++) {

            // Create next level
            q.add(new ArrayList<>());

            for (int j = 0; j < q.get(i).size(); j++) {
                TreeNode node = q.get(i).get(j);

                if (node.left != null) {
                    q.get(i + 1).add(node.left);
                }

                if (node.right != null) {
                    q.get(i + 1).add(node.right);
                }
            }

            // Remove empty last level
            if (q.get(i + 1).isEmpty()) {
                q.remove(i + 1);
                break;
            }
        }

        return q.size();
    }
}