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

    public boolean getPath(TreeNode node,int target,StringBuilder ans ){
        if(node == null ) return false;

        if(node.val == target) return true;

        ans.append('L');
        if(getPath(node.left,target,ans)){
            return true;
        }
        ans.deleteCharAt(ans.length()-1);

        ans.append('R');
        if(getPath(node.right,target,ans)){
            return true;
        }
        ans.deleteCharAt(ans.length()-1);


        return false;

    }

    public String getDirections(TreeNode root, int start, int end) {
            
            StringBuilder path1 = new StringBuilder();
            StringBuilder path2 = new StringBuilder();

             getPath(root,start,path1);
             getPath(root,end,path2);

            int LCA_index = 0;

            for(int i = 0;i<Math.min(path1.length(),path2.length());i++){
                char ch1 = path1.charAt(i);
                char ch2 = path2.charAt(i);

                if(ch1 == ch2){
                    LCA_index++;
                    
                }else{
                    break;
                }
            }

        StringBuilder ans = new StringBuilder();

        for(int i = LCA_index;i<path1.length();i++){
            ans.append("U");
        }

        for(int i = LCA_index;i<path2.length();i++){
            ans.append(path2.charAt(i));
        }

        return ans.toString();
    }
}