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
    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null ) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<n;i++){
                TreeNode curr = q.poll();
                list.add(curr.val);

                if(curr.left != null ) q.offer(curr.left);
                if(curr.right != null ) q.offer(curr.right);
            }
            ans.add(list);

        }

        return ans;

    }
}