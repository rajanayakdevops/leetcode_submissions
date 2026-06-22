class Solution {

    public TreeNode fun(int[] postorder, int poststart, int postend,
                        int[] inorder, int instart, int inend,
                        Map<Integer,Integer> inmap) {
        
        if (poststart > postend || instart > inend) {
            return null;
        }

        // Root is always at the end of postorder segment
        TreeNode root = new TreeNode(postorder[postend]);

        int indexInInorder = inmap.get(root.val);
        int leftNodes = indexInInorder - instart;

        // build left and right subtrees
        root.left = fun(postorder, poststart, poststart + leftNodes - 1,
                        inorder, instart, indexInInorder - 1, inmap);
        
        root.right = fun(postorder, poststart + leftNodes, postend - 1,
                         inorder, indexInInorder + 1, inend, inmap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return fun(postorder, 0, postorder.length - 1,
                   inorder, 0, inorder.length - 1, inmap);
    }
}
