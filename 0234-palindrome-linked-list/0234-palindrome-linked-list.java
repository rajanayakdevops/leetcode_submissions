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
    public static ListNode reverseList(ListNode head){
         // creating pointers
        ListNode curr = head;
        ListNode prev =  null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty or single-node lists are palindromes
        }
        // finding the mid of the linked list
        ListNode fast = head;
        ListNode slow = head;

 

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // this will return the head of the new revesed list
        ListNode reverseNode = reverseList(slow.next);


        slow.next = reverseNode;


        ListNode ptr1 = head;
   
        ListNode ptr2 = slow.next;
   

        while (ptr2 !=  null){
            if(ptr1.val != ptr2.val){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return true;
        
    }
}