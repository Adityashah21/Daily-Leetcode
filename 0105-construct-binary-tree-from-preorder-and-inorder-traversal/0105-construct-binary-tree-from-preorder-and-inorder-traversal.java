class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = map.get(rootValue);

        root.left = build(preorder, left, rootIndex - 1);

        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}