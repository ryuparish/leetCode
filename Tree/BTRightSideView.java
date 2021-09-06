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
    int maxDepth;
    public void addNodes(TreeNode root, List<Integer> answers, int currDepth){
        if(root != null){
            if(currDepth > maxDepth){
                answers.add(root.val);
                maxDepth = currDepth;
            }
            // Travel right until exhausted
            addNodes(root.right, answers, currDepth+1);
            // Travel left when done with right
            addNodes(root.left, answers, currDepth+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answers = new ArrayList<Integer>();
        maxDepth = 0;
        addNodes(root, answers, 1);
        return answers;
    }
}
