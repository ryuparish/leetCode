/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // The key is to understand that if the nodes are split by the root, the root must be the lowest node.
    // If you were to travel any further, one of the children would not be a part of the subtree(root is no longer an
    // ancestor)
    // If this were not the case, then both q and p are greater than or less than together. 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val || (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val,q.val))){
            return root;
        }
        else if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
