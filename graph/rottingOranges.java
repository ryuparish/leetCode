// Gist: Run bfs on all the starting rotten oranges. Be cautious of the edge cases; no oranges, only 1 clean orange
// TC: O(M*N), SC: O(M*N)
class Solution {
    public int orangesRotting(int[][] grid) {
        // Edge case if there is only one orange that is fresh
        int orangeCount = 0, rottenCount = 0, m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1 && grid[0][0] != 1){return 0;}
        
        Queue<int[]> myQueue = new LinkedList<>();
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        for(int i = 0; i < grid.length; ++i){
            
            // Counting the number of fresh oranges for checking if it is possible to rot all the oranges
            for(int j = 0; j < grid[0].length; ++j){
                int currValue = grid[i][j];
                if(currValue == 2){myQueue.offer(new int[]{i, j});}
                if(currValue == 2 || currValue == 1){orangeCount++;}
            }
        }
        
        // Edge case of if there is are no oranges
        if(orangeCount == 0){return 0;}
        
        int minutes = 0;
        
        // BFS all possible oranges and make them rotten
        while(!myQueue.isEmpty()){
            int minuteSize = myQueue.size();
            
            // Processing all the oranges in the current minute
            for(int i = 0; i < minuteSize; ++i){
                int[] currPoint = myQueue.poll();
                
                // Checking all possible directions
                for(int j = 0; j < directions.length; ++j){
                    int nexti = directions[j][0] + currPoint[0];
                    int nextj = directions[j][1] + currPoint[1];
                    
                    // Adding to queue if the orange is fresh
                    if(nexti < m && nexti > -1 && nextj < n && nextj > -1 && grid[nexti][nextj] == 1){
                        myQueue.offer(new int[]{nexti, nextj});
                        grid[nexti][nextj] = 2;
                    }
                }
                orangeCount--;
            }
            minutes++;
        }
        return orangeCount == 0 ? minutes-1 : -1;
    }
}
