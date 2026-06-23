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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null ) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);  
        int current;


        while(!q.isEmpty()){
            int n = q.size();
            current = Integer.MIN_VALUE;

            for(int i = 0;i<n;i++){
                TreeNode node = q.poll();

                current = Math.max(current,node.val);

                if(node.left != null ) q.offer(node.left);

                if(node.right != null ) q.offer(node.right);
            }

            ans.add(current);
        }


        return ans;
    }
}