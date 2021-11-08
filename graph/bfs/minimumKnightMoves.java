// Gist:
// Literally just do bfs with a "visited" boolean array to also represent the graph. The key is to know that you
// will always cover the knight's possible positions with bfs.
// TC: O(n^2) [For every node, you need to explore all neighboring nodes], SC: O(n^2)
class Solution {
    
    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[305][305]; // starting point is at 301, 0 (0,0 in cartesian plane)
        x = Math.abs(x); // Math.abs will work if we consider the symmetry of the answe. (x, y) and (-x, y) ... 
        y = 301 - Math.abs(y); // will have the same answer.
        return bfs(x, y, visited);
    }
    
    private int bfs(int x, int y, boolean[][] visited) {
        int numTurns = 0;
        Queue<int[]> myQueue = new LinkedList<>();
        visited[301][0] = true;
        myQueue.offer(new int[]{301, 0});
        int[][] options = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        
        while(true) { // This can be true since it is guaranteed to contain the answer.
            int queueSize = myQueue.size(); 
            for(int i = 0; i < queueSize; ++i) {
                int[] currPoint = myQueue.poll();
                int currY = currPoint[0];
                int currX = currPoint[1];
                
                if(currY == y && currX == x) {
                    return numTurns;
                }
                
                for(int[] option : options) {
                    int nextVert = currY + option[0];
                    int nextHoriz = currX + option[1];
                    
                    // If we set our exploration area to only the first quadrant
                    // we will reduce our search time by a factor of 4.
                    if(nextVert <= 304 && nextVert >= 0 && nextHoriz <= 304 && nextHoriz >= 0 && !visited[nextVert][nextHoriz]) {
                        myQueue.offer(new int[]{nextVert, nextHoriz});
                        visited[nextVert][nextHoriz] = true;
                    }
                }
            }
            
            numTurns++;
        }
    }
}
