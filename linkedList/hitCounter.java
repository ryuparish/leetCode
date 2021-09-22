lass HitCounter {
    class Node {
        int val;
        Node next;
        Node(int _val){
            val = _val;
        }
    }
    Node head, walker;
    

    /** Initialize your data structure here. */
    public HitCounter() {
        return;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        Node newNode = new Node(timestamp);
        newNode.next = head;
        head = newNode;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        walker = head;
        int counter = 0;
        while(walker != null && walker.val > timestamp - 300){
            counter++;
            walker = walker.next;
        }
        return counter;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
