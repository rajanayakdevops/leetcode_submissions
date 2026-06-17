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
     int ans;

    public void fun(TreeNode node,int number){

        if(node == null ) return;
        
        if(node.left == null && node.right == null ){
            number = number*10+node.val;

            ans += number;

            return;
        }

        fun(node.left,number*10+node.val);
        fun(node.right, number*10+ node.val);
    


    }

      public int sumNumbers(TreeNode root) {

        ans = 0;
        fun(root,0);

        return ans;

        
    }
}