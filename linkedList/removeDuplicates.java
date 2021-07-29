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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        ListNode walker = head;
        while(walker.next != null){
            // If the node in front of the current node is of the 
            // same value, then we "delete" the node in front by "skipping it"
            if(walker.next.val == walker.val){
                walker.next = walker.next.next;
            }
            else{
                walker = walker.next;
            }
        }
        return head;
    }
}
