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
// Gist: To create a hashmap for storing the column and the nodes within that column. Then the also have 
// a queue for storing node and column for bfs. The bfs will ensure the correct adding of the nodes to the
// hashmap (vertically for each column).
// Luckily, the ordering of the values added to List keep their order.
class Solution {
    int minColumn = 0;
    int maxColumn = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null){return answer;}
        HashMap<Integer, List<Integer>> columnMap = new HashMap<Integer, List<Integer>>();
        Queue<Pair<TreeNode, Integer>> myQueue = new ArrayDeque<Pair<TreeNode, Integer>>();
        myQueue.offer(new Pair(root, 0));
        
        // bfs
        while(!myQueue.isEmpty()){
            Pair<TreeNode, Integer> currPair = myQueue.poll();
            TreeNode currNode = currPair.getKey();
            int currColumn = currPair.getValue();
            
            // Adding to the queue for bfs
            if(currNode != null){
                if(!columnMap.containsKey(currColumn)){columnMap.put(currColumn, new ArrayList<Integer>());}
                columnMap.get(currColumn).add(currNode.val);
                if(this.minColumn > currColumn){this.minColumn = currColumn;}
                if(this.maxColumn < currColumn){this.maxColumn = currColumn;}
                
                // Adding both children in order
                myQueue.offer(new Pair(currNode.left, currColumn-1));
                myQueue.offer(new Pair(currNode.right, currColumn+1));
            }
        }
        // Adding the node values to each of the column numbers
        for(int i = this.minColumn; i <= maxColumn; ++i){
            answer.add(columnMap.get(i));
        }
        return answer;
    }
}
