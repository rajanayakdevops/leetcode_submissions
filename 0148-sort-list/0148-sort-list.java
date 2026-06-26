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
class Solution {
     public static ListNode mergeTwoList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                temp = left;
                left = left.next;
            }else{
                temp.next = right;
                temp = right;
                right = right.next;
            }
            if(left == null) temp.next = right;
            else temp.next = left;



        }
        return dummy.next;
    }
    public static ListNode findMiddle( ListNode head ){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
          if(head == null || head.next == null){
            return head;
            // means the Linked List is already sorted
        }
     // this middle function will return the mid node
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        ListNode left = head;
 // here in this right,left we are storing the pinters that
        // are pointing to these node
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoList(left,right);
        
    }
}