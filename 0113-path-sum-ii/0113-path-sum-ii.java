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

    List<List<Integer>> ans;

    public void fun(TreeNode node, int tar, ArrayList<Integer> curr, int sum ){

        if(node == null ) return;

        if(node.left == null && node.right == null ){
            if(sum+node.val == tar){
                curr.add(node.val);
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }
        curr.add(node.val);
        fun(node.left,tar,curr,sum+node.val);
        fun(node.right,tar,curr,sum+node.val);
        curr.remove(curr.size()-1);

        
    }


    public List<List<Integer>> pathSum(TreeNode root, int tar) {

        ans = new ArrayList<>();

        ArrayList<Integer> curr = new ArrayList<>();
        int sum = 0;
        fun(root,tar,curr,sum);

        return ans;

        
    }
}