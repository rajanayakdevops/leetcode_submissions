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

//  here the brute force apprach might be finding all the depest node and applying the lca logic right like this lca(lca(lca(n1, n2), n3), n4) ...


class pair{
    TreeNode node;
    int depth;
    
    pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public pair find(TreeNode node){
        if(node == null ){
            return new pair(null,0);
        }

        pair left = find(node.left);  // assuming that this will going to store the ans or the lca from the left sub tree and its depth right.

        pair right = find(node.right); // and this is going to store the node from the right sub tree and its depth right.

        // now i am current node - i need to check which node i need to return back right .

        // if the node from the left has larger compare to right or vise versa
        //else if both the left and right have the same depth then i need to return the current as the lca right.

        //REMEMBER ->  to add +1 while returning  
        
        if(left.depth > right.depth ){
            return new pair(left.node, left.depth + 1);

        }
        if(right.depth > left.depth ){
            return new pair(right.node, right.depth + 1);

        }

        return new pair(node, left.depth + 1);
    
        

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

// lets have faith in recursion that this is going to return me the desired output

// if i try to compare the patter or to identify the patter then i can say that this is similar to lca but in lcs i need to return the lca of the 2 given nodes right but here i need to return the lca of all the deepest node right.

        pair ans = find(root);

        return ans.node;

        // remember that here in this code we are going to return 2 thing the node and the its depth right and one thing to remember that we are going to find the depth recursively right. 

        
    }
}