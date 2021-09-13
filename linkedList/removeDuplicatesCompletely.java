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
// Gist: Move the .next pointer each time you are done skipping duplicates, but only move onto nodes that are
// unique. Use a sentinel, a dynamic predecessor, and a walker/head.
// Peek and Crawl Technique with Sentinel Node
// TC: O(n), SC: O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0,head);
        ListNode pred = sentinel;
        while(head != null){
            // Skipping over all duplicate nodes
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                // Peek
                pred.next = head.next;
            }
            // Crawl
            else{
                pred = pred.next;
            }
            // Travel to progress the walker
            head = head.next;
        }
        return sentinel.next;
    }
}
