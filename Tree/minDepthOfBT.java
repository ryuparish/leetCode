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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        if(root.left != null){
            leftMin = 1 + minDepth(root.left);
        }
        if(root.right != null){
            rightMin = 1 + minDepth(root.right);
        }
        return Math.min(leftMin, rightMin);
    }
}
