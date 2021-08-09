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
    public int checkBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = checkBalance(root.left);
        int rightSum = checkBalance(root.right);
        if(leftSum == -1 || rightSum == -1){
            return -1;
        }
        if(Math.abs(rightSum - leftSum) > 1){
            return -1;
        }
        // Return which ever is larger because height is the important metric here
        else if(leftSum >= rightSum){
            return 1 + leftSum;
        }
        return 1 + rightSum;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){return true;}
        int answer = checkBalance(root);
        return answer >= 0 ? true : false;
    }
}
