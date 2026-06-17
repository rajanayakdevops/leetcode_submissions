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
    HashMap<TreeNode,TreeNode> map;

    public void print(TreeNode node, List<String> ans){
        StringBuilder current = new StringBuilder();

        current.append(node.val);

        node = map.get(node);

        while(node != null) {
            current.insert(0,"->");
            current.insert(0,node.val);

            node = map.get(node);
            
        }
        ans.add(current.toString());
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // trying the hash map code 
        map = new HashMap<>();
        
        List<String> ans = new ArrayList<>();

        map.put(root,null);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();
            
            if(current.left == null && current.right == null ){
                print(current,ans);
            }

            if(current.left != null ){
                map.put(current.left,current);
                q.offer(current.left);
            }

            if(current.right != null ){
                map.put(current.right,current);
                q.offer(current.right);
            }
        }

        return ans;
    }
}