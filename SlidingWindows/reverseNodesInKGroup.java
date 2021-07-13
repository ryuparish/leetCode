// This solution beats 100% of all other solutions in speed!
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode beginNode = head;
        ListNode endNode = head;
        // Making sure that a single window can be made in the very beginning 
        for(int i = 1; i < k && endNode != null; ++i)
            endNode = endNode.next;
        if(endNode == null || k == 1){return head;}

        // The first endNode is always is the headnode if a single flip is possible
        ListNode returnHead = endNode;
        ListNode newBegin = null;
        ListNode connectionNode = null;

        // The reversal nodes
        ListNode prevNode = beginNode;
        ListNode midNode = beginNode.next;
        ListNode nextNode = null;

        // Only for the first head node
        prevNode.next = null;

        while(true){
            // Reversing the list section
            newBegin = endNode.next;
            for(int i = 0; i < k-1; ++i){
                nextNode = midNode.next;
                midNode.next = prevNode;
                prevNode = midNode;
                midNode = nextNode;
            }
            beginNode.next = nextNode;
            // To connect any previous node after the flip
            if(connectionNode != null){
                connectionNode.next = prevNode;
            }

            // Connecting any previous node and then resetting the begin and ending node window to new position
            connectionNode = beginNode;
            beginNode = newBegin;
            endNode = beginNode;

            // Traversing the endNode to it's next possible position
            for(int i = 1; i < k && endNode != null; ++i){
                endNode = endNode.next;
            }
            if(endNode == null){break;}

            // Resetting the prevNode, midNode, and nextNode
            prevNode = beginNode;
            midNode = prevNode.next;
            nextNode = midNode.next;
        }
        return returnHead;
    }
    //public static void main(String[] args){
    //    ListNode head = new ListNode(1);
    //    ListNode node1 = new ListNode(2);
    //    ListNode node2 = new ListNode(3);
    //    ListNode node3 = new ListNode(4);
    //    ListNode node4 = new ListNode(5);
    //    head.next = node1;
    //    node1.next = node2;
    //    node2.next = node3;
    //    node3.next = node4;
    //    node4.next = null;
    //    ListNode walker = head;
    //    ListNode returnHead = reverseKGroup(head, 1);
    //    while(returnHead != null){
    //        System.out.println(returnHead.val);
    //        returnHead = returnHead.next;
    //    }
    //    return;
    //}
}
