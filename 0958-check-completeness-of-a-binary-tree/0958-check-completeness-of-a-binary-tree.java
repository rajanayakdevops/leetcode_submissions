class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean seenNull = false;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            // Once we encounter a null position,
            // every node after this must also be null.
            if (node == null) {
                seenNull = true;
            } else {

                // Found a real node after a gap
                if (seenNull) {
                    return false;
                }

                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return true;
    }
}