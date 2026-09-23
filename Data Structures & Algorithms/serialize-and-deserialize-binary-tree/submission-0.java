public class Codec {

    private List<List<Integer>> bfslist = new ArrayList<>();

    private void bfs(TreeNode root, int level) {
        if (bfslist.size() == level) {
            bfslist.add(new ArrayList<>());
        }

        if (root == null) {
            bfslist.get(level).add(1001);
            return;
        }

        bfslist.get(level).add(root.val);

        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }

    public String serialize(TreeNode root) {
        bfslist.clear();

        StringBuilder data = new StringBuilder();
        bfs(root, 0);

        for (int i = 0; i < bfslist.size(); i++) {
            for (int j = 0; j < bfslist.get(i).size(); j++) {

                // FIX: append '/' separately
                data.append(bfslist.get(i).get(j));
                data.append('/');
            }

            data.append(1002);
            data.append('/');
        }

        return data.toString();
    }

    private List<List<Integer>> row_null = new ArrayList<>();

    private TreeNode makeTree(int level, int i) {

        if (level == row_null.size()) {
            row_null.add(new ArrayList<>());
            row_null.get(level).add(0);
        }

        if (bfslist.get(level).get(i) == 1001) {
            row_null.get(level).set(
                0,
                row_null.get(level).get(0) + 1
            );
            return null;
        }

        TreeNode root = new TreeNode(bfslist.get(level).get(i));

        root.left = makeTree(
            level + 1,
            (i - row_null.get(level).get(0)) * 2
        );

        root.right = makeTree(
            level + 1,
            (i - row_null.get(level).get(0)) * 2 + 1
        );

        return root;
    }

    public TreeNode deserialize(String data) {

        bfslist.clear();
        row_null.clear();

        int level = 0;
        StringBuilder str = new StringBuilder();

        // FIX: create first level
        bfslist.add(new ArrayList<>());

        for (int i = 0; i < data.length(); i++) {

            if (data.charAt(i) == '/') {

                String token = str.toString();

                if (token.equals("1002")) {
                    level++;

                    // FIX: create next level
                    bfslist.add(new ArrayList<>());

                } else {
                    bfslist.get(level).add(
                        Integer.parseInt(token)
                    );
                }

                str.setLength(0);
                continue;
            }

            str.append(data.charAt(i));
        }

        return makeTree(0, 0);
    }
}