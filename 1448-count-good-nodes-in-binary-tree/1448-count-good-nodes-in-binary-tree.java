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
    int count;

    public void fun(TreeNode node, int maxi ){
        if(node == null ) return;
        if(node.val >= maxi ){
            count++;
            maxi = node.val;
        }

        fun(node.left,maxi);

        fun(node.right,maxi);

    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        count = 0;
        fun(root,Integer.MIN_VALUE);

        return count;
        
    }
}