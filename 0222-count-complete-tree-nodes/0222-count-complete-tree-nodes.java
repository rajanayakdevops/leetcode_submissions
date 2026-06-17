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

//     public int findleft(TreeNode node){
        
//         int count = 0;
//         while(node != null ){
//             count++;
//             node = node.left;
//         }
        
        
//         return count;
//     }

//     public int findright(TreeNode node){
        
//         int count = 0;
//         while(node != null ){
//             count++;
//             node = node.right;
//         }
        
//         return count;
//     }

//     public int find(TreeNode node ){
//         if(node == null ) return 0;

//         int leftheight = findleft(node.left);

//         int rightheight = findright(node.right);

//         if(leftheight == rightheight ){
//             return  (1<<leftheight+1 )- 1 ;
//         } 

//         int leftsubtree = find(node.left);
//         int rightsubtree = find(node.right);

//         return 1+ leftsubtree+rightsubtree;
        
//     }

//     public int countNodes(TreeNode node) {
//         return find(node);
//     }
// }

class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;
    }
}