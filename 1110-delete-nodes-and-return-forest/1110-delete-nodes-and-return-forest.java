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

    // In List the contains takes O(n) time right better to use HashSet
    // List<Integer> list = new ArrayList<>();

    // HashSet Contains takes O(1)
    Set<Integer> list = new HashSet<>();


    public boolean isLeaf(TreeNode node){
        if(node == null ) return true;
        return node.left == null && node.right == null;
    }

    public TreeNode fun(TreeNode node , List<TreeNode> ans){

        if(node == null ) return null;

        TreeNode left = fun(node.left,ans);
        TreeNode right = fun(node.right,ans);

        node.left = left;
        node.right = right;

        if(list.contains(node.val)){
            if(left != null ) ans.add(node.left);
            if(right != null ) ans.add(node.right);

            return null;
        }

        

        return node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] arr) {
        
        
        

        for(int val : arr ) list.add(val);

        List<TreeNode> ans = new ArrayList<>();

        

        root = fun(root,ans);

        if(root != null )
        ans.add(root);

        return ans;


    }
}