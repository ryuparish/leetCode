/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // LinkedList implements the Queue interface
    Stack<TreeNode> myStack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        searchLeft(root);
    }
    
    public int next() {
        TreeNode currNode = myStack.pop();
        if(currNode.right != null){
            searchLeft(currNode.right);
        }
        // Returning the value of currNode, not currNode.right
        return currNode.val;
    }
    
    public boolean hasNext() {
        return !this.myStack.isEmpty();
    }
    
    public void searchLeft(TreeNode root){
        while(root != null){
            myStack.push(root);
            root = root.left;
        }
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
