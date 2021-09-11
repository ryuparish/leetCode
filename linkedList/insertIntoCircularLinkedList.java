/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
// do-while loops can be useful when we are considering a circular case and we want to end the moment
// we reach the initial starting position
// Gist: Two pointers. Dealing with the case of the value being greater than all val, lesser than all val,
// and finally when all the values are the same / only one node.
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node caseNode = new Node(insertVal);
            caseNode.next = caseNode;
            return caseNode;
        }
        Node newNode = new Node(insertVal);
        Node leadHead = head.next;
        Node lagHead = head;
        // This loop will catch the suitable cases of perfect spots, greater than all (unique vals), and
        // lesser than all (unique vals) since this loops only once through the circular list.
        do{
            // Perfect case
            if(newNode.val >= lagHead.val && newNode.val <= leadHead.val){
                lagHead.next = newNode;
                newNode.next = leadHead;
                return head;
            }
            // End of list, but all values are smaller or larger than newNode.val
            else if(lagHead.val > leadHead.val){
                if((insertVal >= leadHead.val && insertVal >= lagHead.val) || (insertVal <= leadHead.val && insertVal <= lagHead.val)){
                    lagHead.next = newNode;
                    newNode.next = leadHead;
                    return head;
                }
            }
            lagHead = lagHead.next;
            leadHead = leadHead.next;
        }while(lagHead != head);
        // Last case, where all the values are the same or there is only a single node
        lagHead.next = newNode;
        newNode.next = leadHead;
        return head;
    }
}
