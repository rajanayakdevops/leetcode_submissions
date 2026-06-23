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

    HashMap<Integer,TreeNode> map;

    public void fun(TreeNode node,int depth){
        if(node == null ) return;

        if(!map.containsKey(depth)){
            map.put(depth,node);
        }
        fun(node.left,depth+1);
        fun(node.right, depth+1);


    }


    public int findBottomLeftValue(TreeNode root) {
        map = new HashMap<>();

        fun(root,0);

        TreeNode node = map.get(map.size()-1);
        return node.val;
    }
}