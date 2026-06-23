class Solution {

    int ans;

    public int min(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }

        int left = min(node.left);
        int right = min(node.right);

        return Math.min(node.val, Math.min(left, right));
    }

    public int max(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int left = max(node.left);
        int right = max(node.right);

        return Math.max(node.val, Math.max(left, right));
    }

    public void fun(TreeNode node){

        if(node == null) return;

        int mn = min(node);
        int mx = max(node);

        ans = Math.max(ans, Math.abs(node.val - mn));
        ans = Math.max(ans, Math.abs(node.val - mx));

        fun(node.left);
        fun(node.right);
    }

    public int maxAncestorDiff(TreeNode root) {

        ans = 0;

        fun(root);

        return ans;
    }
}