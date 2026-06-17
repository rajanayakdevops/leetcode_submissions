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

    public boolean fun(TreeNode node, int target){

        if(node == null ) return false;

        if(node.left == null && node.right == null ){
            return target == node.val;
        }

        return fun(node.left,target-node.val) || fun(node.right,target-node.val);
        
    }

    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null ) return false;

        return fun(root,target);
        
    }
}