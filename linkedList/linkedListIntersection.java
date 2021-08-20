/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        // When the possibly shorter length reaches the end of it's list, it will be offset by n - m, where m
        // is the length of the shorter (or same sized) list and n is the length of the longer list.
        // 
        // Since the shorter-list pointer will reach the end of first and start at the opposing list,
        // along with the longer-list pointer starting at the head of the shorter list, they will be synchronized.
        //
        // On the change that they do not have an intersection, they will still be synchronized and reach null together.
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
