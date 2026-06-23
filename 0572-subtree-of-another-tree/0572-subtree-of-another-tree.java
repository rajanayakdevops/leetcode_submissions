// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {

//     // REMEMBER that preorder + null and Postorder + null -> this results in unique binary tree righ... 
//     // InOrder + null marker does not gurantee binary tree to be unique..... 
    

//     public void print(TreeNode node,List<Integer> ans){
//         if(node == null ){
//             ans.add(null);
//             return;

//         };
//         print(node.left,ans);

//         print(node.right,ans);
//         ans.add(node.val);

//     }

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {

//         List<Integer> parent = new ArrayList<>();
//         print(root,parent);

//         List<Integer> subchild = new ArrayList<>();
//         print(subRoot,subchild);

//         if(parent.size() < subchild.size()) return false;

//         return Collections.indexOfSubList(parent, subchild) != -1;
        
//     }


    
// }



class Solution {

    public void checkserialize(TreeNode node, StringBuilder ans ){
        if(node == null){
            ans.append("*,");
            return;
        }

        ans.append("$").append(node.val).append(",");
        checkserialize(node.left,ans);
        checkserialize(node.right,ans);

    }
    
    public String serialize(TreeNode node) {
        
        StringBuilder sb = new StringBuilder();

        checkserialize(node,sb);

        return sb.toString();
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String parent = serialize(root);
        String child = serialize(subRoot);

        return parent.contains(child);
    }
}