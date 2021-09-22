/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
// Gist: In-Order traversal with memoization of two nodes, first (only once) and then last
// (every time). The very first node to see any code after the base case will always be the
// smallest node due to the way BSTs are structured.
class Solution {
    Node first = null;
    Node last = null;
    private void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            
            // This will be seen by the smallest value first out of all nodes
            // Check if there is at least the first node
            if(this.first == null){
                this.first = root;
                this.last = root;
            }
            else{
                // Joining the nodes together doubly and setting new last
                this.last.right = root;
                root.left = this.last;
                this.last = root;
            }
            
            inOrderTraversal(root.right);
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root == null){return null;}
        inOrderTraversal(root);
        this.first.left = this.last;
        this.last.right = this.first;
        return this.first;
    }
}
