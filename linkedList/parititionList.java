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
// Gist: Create two head-tail node pairs and grow them by traversing the list with a walker. Everything greater than
// or equal to x will be placed in the second list and everything else in the first list. Then you point the first list
// tail at the second list's head.
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(), newTail = newHead, oldHead = new ListNode(), oldTail = oldHead, walker;
        walker = head;
        while(walker != null){
            if(walker.val >= x){
                // Moving the tail and setting prevtail to the new tail.
                newTail.next = walker;
                newTail = newTail.next;
            }
            else{
                // Moving the tail and setting prevtail to the new tail.
                oldTail.next = walker;
                oldTail = oldTail.next;
            }
            walker = walker.next;
        }
        newTail.next = null;
        oldTail.next = newHead.next;
        return oldHead.next;
    }
}
