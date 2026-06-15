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
    public ListNode reverseList(ListNode head) {
        
        ListNode dummy = null;
        ListNode node = head;


        while(node != null ){
             
             ListNode second = node.next;
            node.next = dummy;
            dummy = node;
            node = second;

        }
        

        return dummy;
    }
}