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

// approach 
// in geeks for geek there is some difference some variation in this quesiton right so better to see that question because there we need user reverse and trim function in order to find the valid ans right. 

// 2. using the recursion that we have used right. 

// 3 . optimised code - use the same logic used in recursion but in iterative way 


// class Solution {

//     public ListNode find(ListNode l1 , ListNode l2, int carry){

//         if(l1 == null && l2 == null && carry == 0 ){
//             return null;
//         }

    
        
//         int sum = carry;

//         if(l1 != null){
//             sum += l1.val;
//         }
//         if(l2 != null ){
//             sum += l2.val;
//         }

//        ListNode current = new ListNode(sum % 10);

// // this is the imp thing right we have handele the case if the comming node is null right but what if the current node we are working is null then calling node.next does not make any sense right.

//        current.next = find((l1 != null )? l1.next : null, (l2 != null)? l2.next: null, sum / 10 );


//     return current;


//     }

//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         // faith in recursion - this is going to return the head of the node i am looking for right.
//         return find(l1,l2,0);

//     }
// }

// this is the iterative code with better space complexity right 
// remember that here in this code we are not using recursion right and for each addition we are creating a new node right and with this we are updating the l1 and l2 right. 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        // dummy node
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // continue while anything is left
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // create current node
            tail.next = new ListNode(sum % 10);

            // move tail
            tail = tail.next;

            // update carry
            carry = sum / 10;
        }

        return dummy.next;
    }
}
