

// class Solution {

//  // this is the brute force right.....    

//     int ans;

//     public int min(TreeNode node){
//         if(node == null){
//             return Integer.MAX_VALUE;
//         }

//         int left = min(node.left);
//         int right = min(node.right);

//         return Math.min(node.val, Math.min(left, right));
//     }

//     public int max(TreeNode node){
//         if(node == null){
//             return Integer.MIN_VALUE;
//         }

//         int left = max(node.left);
//         int right = max(node.right);

//         return Math.max(node.val, Math.max(left, right));
//     }

//     public void fun(TreeNode node){

//         if(node == null) return;


// // in these 2 line there is a catch u must be wonderin we require the min value from the subtree right.
// // then why we are passing the current node... this is because if u do min(node.left ot right ) then the min wil return integer max value due to the base case right... and that will affect the overall answer because we are finding the overall max value right... So the smarter was is to stop calling the max or min for leaf node right... 
//         int mn = min(node);


//  // u again be wondering to find the max we require the min value that we can pick from the subtree right.
//  // but if u notice we are quired to return the max absolute value right.... supoose current value is 50 and min subtree value is 45 and max sub tree value is 90 then if u see the abs differnce then u will notice that we are getting the max absoute value from the max value from the subtree right.. 

//  // So we need to check for both max and min right.. 
//  66       
//         int mx = max(node);

//         ans = Math.max(ans, Math.abs(node.val - mn));
//         ans = Math.max(ans, Math.abs(node.val - mx));

//         fun(node.left);
//         fun(node.right);
//     }

//     public int maxAncestorDiff(TreeNode root) {

//         ans = 0;

//         fun(root);

//         return ans;
//     }
// }


// O_P_T_I_M_I_S_I_

class pair{
    TreeNode node;
    int min;
    int max;

    public pair(TreeNode node, int min, int max){
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

class Solution {

    int ans;

    public pair fun(TreeNode node ){

        if(node == null){
            return new pair(null,
                            Integer.MAX_VALUE,
                            Integer.MIN_VALUE);
        }

        pair left = fun(node.left);
        pair right = fun(node.right);

        int mn = Math.min(node.val,
                 Math.min(left.min, right.min));

        int mx = Math.max(node.val,
                 Math.max(left.max, right.max));

        ans = Math.max(ans, Math.abs(node.val - mn));
        ans = Math.max(ans, Math.abs(node.val - mx));

        return new pair(node, mn, mx);
    }

    public int maxAncestorDiff(TreeNode root) {

        ans = 0;

        fun(root);

        return ans;
    }
}