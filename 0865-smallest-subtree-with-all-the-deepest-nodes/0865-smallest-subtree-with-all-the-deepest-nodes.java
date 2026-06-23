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

class pair{
    TreeNode node;
    int depth;

    public pair(TreeNode node , int depth ){
        this.node = node;
        this.depth = depth;
    }

}

class Solution {

    public pair fun(TreeNode node ){
        if(node == null ) return new pair(null,0);

        pair left = fun(node.left);

        pair right = fun(node.right);

        if(left.depth > right.depth ) return new pair(left.node,left.depth+1);

        if(right.depth > left.depth ) return new pair(right.node, right.depth+1);

        return new pair(node,left.depth+1); // this line will strik when both the left and right side have the same depth;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

    pair result = fun(root); // this function is going to return us a single pair class in which we will be having the TreeNode and the depth associated to that node right.

    return result.node;


    }
}