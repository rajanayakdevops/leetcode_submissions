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

//     // Brute force approach -->  this is the most brute force apprach right.... 
//     // Another apprach -> start marking each node like 1 ,2,3,4,5,  and with this cont the total count since we need to find the completeness then the numbering should be in continuous order right... 
// //  if any point number become more than total number of nodes we will return false ... see the code below.

//     public int fun(TreeNode node,boolean flag){
//         if(node == null ) return 0;

//         int left = fun(node.left,true);
//         int right = fun(node.right,false);

//         if(left == -1 || right == -1 ) return -1;

//         if(left < right ) return -1;
        
//         return 1 + left+ right;


//     }
//     public boolean isCompleteTree(TreeNode root) {

//         int ans = fun(root,false);

//         if(ans == -1 ) return false;

//         return true;
        
//     }
// }

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

    public int count(TreeNode node ){
        if(node == null ) return 0;

        return 1 + count(node.left)+count(node.right);

    }

    public boolean fun(TreeNode node, int index, int total ){

        if(node == null ) return true;

        if(index > total ) return false;

        return fun(node.left,2*index,total) && fun(node.right,2*index+1,total);
        

    }
    public boolean isCompleteTree(TreeNode root) {
        
        int n = count(root);

        return fun(root,1,n);


    }
}