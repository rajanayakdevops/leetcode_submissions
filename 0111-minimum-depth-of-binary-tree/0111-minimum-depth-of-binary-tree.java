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
    public int minDepth(TreeNode root) {

        // there are 2 approach 
        // 1->  Using recursion ( in recursion just use 1+ Math.min(_)  in place of max that we used for finding the depth of the treee);
        // 2-> Using bfs (in this we will return from the while loop when we encounter every first leaf node right );

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null ) return 0;

        q.offer(root);

        int minDep = 0;

        while(!q.isEmpty()){
            
        int n = q.size();
        
        minDep++;

        for(int i = 0;i<n;i++){
            TreeNode node = q.poll();

            if(node.left == null && node.right == null ) return minDep;
            
            if(node.left != null ) q.offer(node.left);
            if(node.right != null ) q.offer(node.right);
        }


        }

        return minDep;
    }
}