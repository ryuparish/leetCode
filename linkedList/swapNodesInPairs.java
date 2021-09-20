class Solution {
    public ListNode swapPairs(ListNode head) {
        // Covering edge case of one or no nodes
        if(head == null || head.next == null){return head;}
        
        ListNode leadHead = head.next;
        ListNode lagHead = head;
        ListNode swapper = null;
        ListNode returnHead = leadHead;
        ListNode prevNode = null;
        while(leadHead != null){
            prevNode = lagHead;
            lagHead.next = leadHead.next;
            leadHead.next = lagHead;
            swapper = lagHead;
            lagHead = leadHead;
            leadHead = swapper;
            if(leadHead.next != null){
                lagHead = leadHead.next;
                leadHead = leadHead.next.next;
                prevNode.next = leadHead == null ? lagHead : leadHead;
            }
            else{leadHead = leadHead.next;}
        }
        return returnHead;
    }
}
