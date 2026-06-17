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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();


        if(root == null ) return ans;

        q.offer(root);


        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> curr = new ArrayList<>();

            for(int i = 0;i<n;i++){

                TreeNode node = q.poll();
                curr.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null ) q.offer(node.right);
            }

            ans.add(0,curr);
        }

        return ans;
    }
}