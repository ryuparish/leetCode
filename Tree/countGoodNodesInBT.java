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
// Gist: Travel the tree with dfs and carry along the max value while dfs'ing. If you find a value larger than
// the current maxVal, increase count because there hasn't been a larger value down to that path. Also set the
// current maxVal to the current value of the larger valued node.
// TC: O(n), SC: O(1)
class Solution {
    int count = 0;
    private void dfs(TreeNode root, int maxVal){
        if(root == null){return;}
        if(root.val >= maxVal){
            this.count++;
            maxVal = root.val;
        }
        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return this.count;
    }
}
