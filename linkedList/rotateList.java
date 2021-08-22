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
// Original Solution
// TC: O(n)
// SC: O(n)
//class Solution {
//    public ListNode rotateRight(ListNode head, int k) {
//        ArrayList<Integer> origVals = new ArrayList<Integer>();
//        if(head == null || k == 0){return head;}
//        ListNode walker = head;
//        int listSize = 0;
//        // Getting the size of the list
//        while(walker != null){
//            listSize++;
//            origVals.add(walker.val);
//            walker = walker.next;
//        }
//        int offsetIdx = k % listSize;
//        if(offsetIdx == 0){return head;}
//        // Getting the index that would be placed into the first position
//        offsetIdx = listSize - offsetIdx;
//        walker = head;
//        // Swapping the further value with the closer value listSize number of times
//        for(int i = 0; i < listSize; ++i){
//            walker.val = origVals.get(offsetIdx);
//            walker = walker.next;
//            offsetIdx = (++offsetIdx) % (listSize);
//        }
//        return head;
//    }
//}
// Optimal Solution
// TC O(n)
// SC O(1)
class Solution{
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null){return head;}
        // First we need to set a dummyNode to make everything easier
        ListNode dummyNode = new ListNode(0,head);
        ListNode endNode = dummyNode;
        ListNode splitNode = dummyNode;
        int i;
        // Gets the last node and counts the nodes at the same time
        for(i = 0; endNode.next != null; ++i){
            endNode = endNode.next;
        }
        // Now going until the splitNode position (the index that would trade with the first spot) -1
        for(int j = i-(k % i); j > 0; --j){
            splitNode = splitNode.next;
        }
		// Pointing the endNode to the beginning
		// then pointing the beginning to be the node after 
        // splitNode, and finally setting splitNode.next = null
        endNode.next = dummyNode.next;
        dummyNode.next = splitNode.next;
        splitNode.next = null;
        return dummyNode.next;
    }
}
