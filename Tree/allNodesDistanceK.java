/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC: O(2n) -> O(n), SC: O(n)
class Solution {
    // Gist: The path from the root to the target node will be recorded into a hashmap, with each node stored
    // with it's distance from the target node. For every node that is away from this path (including the target)
    // we can add 1 to the distance and we always check if the node is on the path. If it is, we will use the stored distance instead.
    HashMap<TreeNode, Integer> myMap = new HashMap<TreeNode, Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<Integer>();
        findPath(root, target);
        dfs(root, target, k, 0, answer);
        return answer;
    }
    public int findPath(TreeNode root, TreeNode target){
        if(root == null){return -1;}
        if(root == target){
            myMap.put(root, 0);
            return 0;
        }
        int left = findPath(root.left, target);
        if(left >= 0){
            myMap.put(root, left+1);
            return left+1;
        }
        int right = findPath(root.right, target);
        if(right >= 0){
            myMap.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    public void dfs(TreeNode root, TreeNode target, int k, int distance, List<Integer> answer){
        if(root == null){return;}
        if(myMap.containsKey(root)){distance = myMap.get(root);}
        if(distance == k){answer.add(root.val);}
        dfs(root.left, target, k, distance+1, answer);
        dfs(root.right, target, k, distance+1, answer);
    }
}
