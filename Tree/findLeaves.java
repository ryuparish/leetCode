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

// Ryu's Original Solution:
// TC: O(n^2), SC: O(n)
//class Solution {
//    public List<List<Integer>> findLeaves(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        fillArray(res, root);
//        return res;
//    }
//    
//    public void fillArray(List<List<Integer>> res, TreeNode root) {
//        
//        // R: Until the root is added to the result.
//        while (root != null) {
//            
//            // R: A new outer layer of the leaves.
//            List<Integer> layer = new ArrayList<Integer>();
//            
//            // R: If there are no children, then we add ourself and then we exit by setting root to null.
//            if (root.left == null && root.right == null) {
//                List<Integer> finalLayer = new ArrayList<Integer>();
//                finalLayer.add(root.val);
//                res.add(finalLayer);
//                root = null;
//            }
//            
//            // R: Adding regular layer if there are children
//            else {
//                addNodes(layer, root);
//                res.add(layer);
//            }
//        }
//    }
//    
//    // R: Removes and adds nodes to a given List<Integer>
//    public boolean addNodes(List<Integer> outerLayer, TreeNode root) {
//        
//        // R: Edge case catcher.
//        if (root == null)
//            return false;
//
//        // R: Add value and flag removal.
//        if (root.left == null && root.right == null) {
//            outerLayer.add(root.val);
//            return true;
//        }
//        
//        // R: If they are leaves we prune
//        if (addNodes(outerLayer, root.left))
//            root.left = null;
//        
//        if (addNodes(outerLayer, root.right))
//            root.right = null;
//        
//        return false;
//    }
//}

// Optimal Solution
// TC: O(n), SC: O(n)
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<List<Integer>>();
        fillArray(root);
        return res;
    }
    
    public int fillArray(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int leftChildHeight = fillArray(root.left);        
        int rightChildHeight = fillArray(root.right);
        
        // R: We need to increment by one since the we are one level above
        int currHeight = Math.max(leftChildHeight, rightChildHeight) + 1;
        
        // R: If we are at height x, there should be x+1 lists. 0 -> 1, 1 -> 2...
        // R: So at height x, if there are only x lists, we are the first of the new
        // R: nested list, so we need to insert an empty list for indexing.
        
        if (currHeight == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(currHeight).add(root.val);
        return currHeight;
    }
}
