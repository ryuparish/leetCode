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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      // Empty case
      if (head == null) {
        return null;
      }
      
      // Traverse list until left is 0 and right is n, where n is the number
      // of nodes we are the reverse.
      ListNode midNode = head;
      ListNode lagNode = null;
      
      // While the left is not zero or negative
      while (left > 1) {
        lagNode = midNode;
        midNode = midNode.next;
        --left;
        --right;
      }
      
      // Flipping the interval
      ListNode detachPointNode = lagNode;
      ListNode attachPointNode = midNode;
      ListNode leadNode = null;
      while (right > 0) {
        leadNode = midNode.next;
        midNode.next = lagNode;
        lagNode = midNode;
        midNode = leadNode;
        right--;
      }
      
      // Attaching the flipped portion
      if (detachPointNode != null) {
        detachPointNode.next = lagNode;
        
      // In the case that head is the start of the reversal, detachPointNode would
      // would be null since no traversal to the spot was performed.
      // So, we set the head node to be the last node that was reversed.
      } else {
        head = lagNode;
      }

      attachPointNode.next = leadNode;
      return head;
    }
}
