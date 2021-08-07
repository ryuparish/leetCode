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
class Solution {
    public boolean opposingDfs(TreeNode leftNode, TreeNode rightNode){
        // Base Case where both are null
        if(leftNode == null && rightNode == null){
            return true;
        }
        // Base Case where both have values and need to be recursed deeper
        // by checking inward children and outward children
        else if(leftNode != null && rightNode != null){
            return (leftNode.val == rightNode.val) && opposingDfs(leftNode.left, rightNode.right) && opposingDfs(leftNode.right, rightNode.left);
        }
        // Base Case where only one is null
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        // If root is null or if both children are null then it is symmetrical
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
		// If the children are different and both exist
        else if(root.left != null && root.right != null){
            return opposingDfs(root.left, root.right);
        }
        // Reaching this line would mean that both children are different or only one of the children is null
        return false;
    }
}
