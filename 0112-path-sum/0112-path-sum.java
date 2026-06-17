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

            // here u need to remember that once we hit the leaf node we need to first subtract the current node val and then we need to check weather target == 0 or not right.... 
            return target == node.val;
        }

        return fun(node.left,target-node.val) || fun(node.right,target-node.val);
        
    }

    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null ) return false;

        // return fun(root,target);
        
        int sum = 0;
        return funn(root,target,sum);
        
    }

    public boolean funn(TreeNode node ,int target, int sum){

        if(node == null ) return false;

        if(node.left == null && node.right == null ){
            return sum+node.val == target;
        }

        return funn(node.left,target,sum+node.val) || funn(node.right,target,sum+node.val);


    }
}