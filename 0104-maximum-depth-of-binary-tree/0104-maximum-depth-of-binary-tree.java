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

    public int maxdep(TreeNode node){
        if(node == null ) return 0;

        return 1+ Math.max(maxdep(node.left),maxdep(node.right));
    }

    public int maxDepth(TreeNode root) {

    if(root == null ) return 0;

        return maxdep(root);
        
    }
}