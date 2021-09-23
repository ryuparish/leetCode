// The idea to make the get function (which needs to update the linked list everytime) O(1), is to store
// Nodes inside of the HashMap then just utilize the O(1) capability of the hashmap to remove and 
// place in front a duplicate node in the linked list. The linked list provides the Least-Recent aspect.
// 
// The reasoning behind he doubly linked list is for the purpose of removing and adding nodes in O(1) time complexity.
class LRUCache {
    class Node{
        Node prev, next;
        int key, value;
        public Node(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }
    }
    Node Head = new Node(0,0) , Tail = new Node(0,0);
    HashMap<Integer, Node> myMap = new HashMap<Integer, Node>();
    int maxSize;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        Head.next = Tail;
        Tail.prev = Head;
    }
    
    public int get(int key) {
        if(!myMap.containsKey(key)){return -1;}
        Node currNode = myMap.get(key);
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;
        currNode.next = Head.next;
        currNode.prev = Head;
        Head.next.prev = currNode;
        Head.next = currNode;
        //printList();
        return currNode.value;
    }
    
    public void put(int key, int value) {
        // We remove if we have a match first so we don't accidentally remove an arbitrary node when we
        // really just need to rearrange the list.
        if(myMap.containsKey(key)){
            Node currNode = myMap.get(key);
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            myMap.remove(key);
        }
        // Removal if map has no match and is also full
        if(myMap.size() == this.maxSize){
            int deleteKey = Tail.prev.key;
            Tail.prev.prev.next = Tail;
            Tail.prev = Tail.prev.prev;
            myMap.remove(deleteKey);
        }
        Node newNode = new Node(key, value);
        myMap.put(key, newNode);
        newNode.next = Head.next;
        newNode.prev = Head;
        Head.next.prev = newNode;
        Head.next = newNode;
        //printList();
    }
    
    //public void printList(){
    //    Node walker = Head;
    //    while(walker != null){
    //        System.out.print("{" + walker.key + "," + walker.value + "} "); 
    //        walker = walker.next;
    //    }
    //    walker = Tail;
    //    System.out.println("");
    //    //Remember to read this next print out in REVERSE! It it printed from FRONT TO BACK.
    //    while(walker != null){
    //        System.out.print("{" + walker.key + "," + walker.value + "} "); 
    //        walker = walker.prev;
    //    }
    //    System.out.println("");
    //}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
