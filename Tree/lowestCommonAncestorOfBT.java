/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// DFS to find more than 1 of mid, left, or right "trues"
// In order to find the solution to this problem, you need to have both children between the currNode
// or you need to have one child below the node and the currnode itself has to be the other child.
class Solution {
    TreeNode answer;
    // dfs to find at least 2 trues from mid, left, and right
    // This algorithm will continue to run even after the answer is found
    private boolean findAnswer(TreeNode root, int pval, int qval){
        if(root == null){return false;}
        int mid = (root.val == pval || root.val == qval) ? 1 : 0;
        int left = findAnswer(root.left, pval, qval) ? 1 : 0;
        int right = findAnswer(root.right, pval, qval) ? 1 : 0;
        if(left+right+mid >= 2){this.answer = root;}
        return (mid+right+left > 0);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int mid=0, left=0, right=0;
        findAnswer(root, p.val, q.val);
        return this.answer;
    }
}
