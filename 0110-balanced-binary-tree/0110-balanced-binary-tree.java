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

        public int depth(TreeNode node){
            if(node == null ) return 0;

            return 1 + Math.max(depth(node.left),depth(node.right));
        }

        public boolean fun(TreeNode node){
            if(node == null ) return true;

            int left = depth(node.left);
            int right = depth(node.right);

            if(Math.abs(left-right) > 1 ) return false;

            return fun(node.left) && fun(node.right);

        }

    public boolean isBalanced(TreeNode root) {
        if(root == null ) return true;

        return fun(root);
    }
}