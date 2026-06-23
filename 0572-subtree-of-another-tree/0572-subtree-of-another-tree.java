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

    public void print(TreeNode node,List<Integer> ans){
        if(node == null ){
            ans.add(null);
            return;

        };

        ans.add(node.val);
        print(node.left,ans);

        print(node.right,ans);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        List<Integer> parent = new ArrayList<>();
        print(root,parent);

        List<Integer> subchild = new ArrayList<>();
        print(subRoot,subchild);

        if(parent.size() < subchild.size()) return false;

        return Collections.indexOfSubList(parent, subchild) != -1;
        
    }
}