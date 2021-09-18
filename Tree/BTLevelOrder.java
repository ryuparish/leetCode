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
// Gist: We do bfs, initialize an int at zero, and offer the root node. Within this bfs while loop
// , we do a for loop for the size of the current queue (set outside of the for loop). For every
// for-loop loop, we add the number polled from the queue and then we add the kids if they are
// not null. This will provide us with the correct ordering. We then increment the level int
// outside of the for loop.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }
    private List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
        if(root != null){myQueue.offer(root);}
        int currLevel = 0;
        while(!myQueue.isEmpty()){
            answer.add(new ArrayList<Integer>());
            // At each level there are at most 2^n nodes, although this is only
            // for a full tree.
            int levelSize = myQueue.size();
            // This loop will poll every node on the current level and add the children
            // in the correct order at the same time
            for(int i = 0; i < levelSize; ++i){
                TreeNode currNode = myQueue.poll();
                answer.get(currLevel).add(currNode.val);
                if(currNode.left != null){myQueue.offer(currNode.left);}
                if(currNode.right != null){myQueue.offer(currNode.right);}
            }
            currLevel++;
        }
        return answer;
    }
}
