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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leadHead = head;
        // lagHead will be the (n+1)th node from the last so we can remove the nth node
        ListNode lagHead = null;
        int counter = 1;
        while(leadHead != null){
            // lagHead begins traversal lagging n positions behind the leadHead
            if(counter == n){lagHead = head;}
            if(counter > n+1){
                lagHead = lagHead.next;
            }
            leadHead = leadHead.next;
            counter++;
        }
        // In case the node to be removed is the very first node
        if(counter-1 == n){return head.next;}
        // This conditional only works if the ListNode to be removed is not the very first node.
        // This is due to the fact that we will need to move the headNode in order to deal with removing the first node
        else if(lagHead != null){
            lagHead.next = lagHead.next.next;
        }
        return head;
    }

}
