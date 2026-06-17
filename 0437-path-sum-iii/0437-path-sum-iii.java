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
    HashMap<Long,Integer> map;

    public void fun(TreeNode node, int tar, long sum ){
        if(node == null ) return;

        sum += node.val;

        if(map.containsKey(sum - tar)){
            ans += map.get(sum-tar);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        fun(node.left,tar,sum);
        fun(node.right,tar,sum);

        map.put(sum,map.get(sum)-1);
        sum -= node.val;
    }
    
    public int pathSum(TreeNode root, int tar) {

         map = new HashMap<>();   // key , occurence;
         map.put(0L,1);

        ans = 0;
        long sum = 0;
        fun(root,tar,sum);

        return ans;


        
    }
}