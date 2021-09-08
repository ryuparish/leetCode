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

class Solution {
    Node firstNode;
    Node lastNode;
    private void dfs(Node root){
        if(root != null){
            dfs(root.left);
            // If heads are empty
            // For some reason, the recursive calls will not set the firstNode's value when it returns
            // As in, the reference is not updated for earlier recursive calls
            if(firstNode == null){
                this.firstNode = root;
                this.lastNode = root;
            }
            else{
                Node prevNode = this.lastNode;
                this.lastNode.right = root;
                this.lastNode = this.lastNode.right;
                this.lastNode.left = prevNode;
            }
            dfs(root.right);
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root == null){return null;}
        dfs(root);
        // Then linking the first and last nodes
        firstNode.left = lastNode;
        lastNode.right = firstNode;
        return firstNode;
    }
}
