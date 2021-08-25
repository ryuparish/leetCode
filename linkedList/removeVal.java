class Solution{
    public removeVal(ListNode head, int val){
        while(head != null && head.val == val){head = head.next;}
        ListNode lagHead = head != null ? head : null;
        ListNode leadHead = lagHead != null ? lagHead.next : null;
        while(leadHead != null){
            while(leadHead != null && leadHead.val == val){
                lagHead.next = leadHead.next;
                leadHead = lagHead.next;
            }
            if(leadHead != null){
                lagHead = leadHead;
                leadHead = leadHead.next;
            }
        }
        return head;
    }
}
