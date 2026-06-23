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

    public boolean fun(TreeNode node1, TreeNode node2){
        
        if(node1 == null && node2 == null ) return true;
        if(node1 == null || node2 == null ) return false;
        if(node1.val != node2.val ) return false;


        boolean flip = fun(node1.left ,node2.left) && fun(node1.right,node2.right);

        boolean notflip = fun(node1.left,node2.right) && fun(node1.right,node2.left);

        return flip || notflip;
        
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null ) return true;

    return fun(root1,root2);

        
    }
}