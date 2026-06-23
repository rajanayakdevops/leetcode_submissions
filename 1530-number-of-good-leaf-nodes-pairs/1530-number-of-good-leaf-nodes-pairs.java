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

    int count = 0;
    int distance;

    public List<Integer> fun(TreeNode node){

        List<Integer> res = new ArrayList<>();

        if(node == null){
            return res;
        }

        // Leaf node
        if(node.left == null && node.right == null){
            res.add(1);
            return res;
        }

        List<Integer> left = fun(node.left);
        List<Integer> right = fun(node.right);

        // Count valid leaf pairs
        for(int l : left){
            for(int r : right){
                if(l + r <= distance){
                    count++;
                }
            }
        }

        // Return distances to parent
        for(int l : left){
            res.add(l + 1);
        }

        for(int r : right){
            res.add(r + 1);
        }

        return res;
    }

    public int countPairs(TreeNode root, int distance) {

        this.distance = distance;

        fun(root);

        return count;
    }
}