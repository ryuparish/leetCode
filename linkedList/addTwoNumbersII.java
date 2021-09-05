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
// TC: O(n), where n is the total number of nodes
// SC: O(1)
class Solution {
    public ListNode reverseList(ListNode head){
        ListNode lagHead = head;
        ListNode midHead = head.next;
        ListNode leadHead = midHead != null ? midHead.next : null;
        lagHead.next = null;
        while(midHead != null){
            midHead.next = lagHead;
            lagHead = midHead;
            midHead = leadHead;
            if(leadHead != null){leadHead = leadHead.next;}
        }
        return lagHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int remainder = 0;
        ListNode currNode = null;
        while(l1 != null || l2 != null || remainder > 0){
            int sum = l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += remainder;
            remainder = sum / 10;
            ListNode newNode = new ListNode(sum % 10, currNode);
            currNode = newNode;
            l1 = l1 != null ? l1.next: l1;
            l2 = l2 != null ? l2.next: l2;
        }
        return currNode;
    }
}
