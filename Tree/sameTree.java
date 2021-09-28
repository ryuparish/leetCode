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
// Gist: We perform dfs with both nodes of the trees until there is a mismatch in existence or a mismatch in values. If they
// are the same values, then we recurse until we find the same null(true) or a mismatch happens(false).
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Checking if the nodes are both null and should be returned
        if(p == null && q == null){
            return true;
        }
        // Checking if the values are not identical in structure or in value
        // Will short circuit if the first two are true, so the last one will be checked iff both are not null
        if((p == null && q != null) || (q == null && p != null) || (p.val != q.val)){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
