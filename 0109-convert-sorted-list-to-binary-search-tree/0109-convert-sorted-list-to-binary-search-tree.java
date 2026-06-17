/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

// look the difference btw 108 is that we can jump directly in btw. so the only way to build the tree is from left to right ok . so in order to start from left first we need to move to left -> left ... until we hit base case or null is reached... so this we are finding mid( we explictly find the sze of the list right ) an then move towards start right

    ListNode head;

    public TreeNode fun(int start, int end ){
        if(start > end ) return null;

        int mid = start + (end - start )/2;

// this line is used to move to the extreme left until we reach the null or very end. 
//now this left will contain null righ because it come back after  hitting the base case;
        TreeNode left = fun(start,mid-1);  
        
// here we created the left most node using the head pointer  
        TreeNode leftMost = new TreeNode(head.val);

// poining the node to the left... 
        leftMost.left = left;

// here we move forward the head to the next node;
        head = head.next;

// and this is recursion right... the main task was to build the left and then rest will be taken care by recursion..
        leftMost.right = fun(mid+1,end);

        return leftMost;



    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;

        int n = count(head);

        if(n == 0 ) return null;

        return fun(0,n-1);
    }

    public int count(ListNode node){
        int cnt = 0;

        while(node != null ){
            cnt++;
            node = node.next;
        }

        return cnt;
    }
}