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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null ) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        boolean flag = true;

        while(!q.isEmpty()){
            int n = q.size();

            Deque<Integer> curr = new LinkedList<>();

            for(int i = 0;i<n;i++){
                TreeNode node = q.poll();

                if(flag){
                    curr.addLast(node.val);    
                }else{
                    curr.addFirst(node.val);
                }

                if(node.left != null ) q.offer(node.left);
                if(node.right != null ) q.offer(node.right);
            }

            ans.add(new ArrayList<>(curr));
            flag = !flag;


        }

        return ans;
        
    }
}