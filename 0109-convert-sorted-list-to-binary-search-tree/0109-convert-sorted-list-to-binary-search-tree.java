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
    ListNode head;

    public TreeNode fun(int start, int end ){
        if(start > end ) return null;

        int mid = start + (end - start )/2;

        TreeNode left = fun(start,mid-1);

        TreeNode leftMost = new TreeNode(head.val);

        leftMost.left = left;

        head = head.next;

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