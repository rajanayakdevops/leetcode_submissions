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

    public TreeNode fun(TreeNode node1, TreeNode node2 ){

        if(node1 == null && node2 == null ) return null;
        
        if(node1 != null && node2 != null ){
            TreeNode head = new TreeNode(node1.val+node2.val);

            head.left = fun(node1.left,node2.left);
            head.right = fun(node1.right,node2.right);

            return head;
      }
      if(node1 == null ){
            return node2;
      }

    return node1;

    }

    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {

        return fun(node1,node2);


    }
}