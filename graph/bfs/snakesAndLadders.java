/*
   Gist: We can converty the board into a 1D array and just use breadth first search for each of 
   6 options we have iteratively and with each group of steps we increment the
   number of steps until we find the goal.
   
   With this version of bfs, it is helpful to just skip the past to the next index for every index
   
*/
class Solution {
    public int snakesAndLadders(int[][] board) {
        
        // Loop in a snake-like fashion
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        return bfs(arr, n * n);
    }
    
    private int bfs(int[] flatBoard, int target) {
        Queue<Integer> myQueue = new LinkedList<Integer>();
        boolean[] visited = new boolean[target];
        // Edge case of starting on a ladder end is covered here
        // Adding the first starting point only
        int start = flatBoard[0] != -1 ? flatBoard[0] - 1 : 0;
        myQueue.offer(start);
        visited[start] = true;
        
        // bfs
        int numSteps = 0;
        while(!myQueue.isEmpty()){
            int currSize = myQueue.size();
            while(currSize-- > 0) {
                int currIdx = myQueue.poll();
                if(currIdx == target-1){return numSteps;}
                
                // Edge case of starting at an second ladder beginning covered here.
                // Traverses from the index after the dequeued spot to the next 5 places after that (6 possible
                // dice rolls)
                
                // Why <= ?
                for(int i = currIdx + 1; i <= Math.min(currIdx + 6, target-1); ++i){
                    
                    // The -1 below is NOT for getting behind the target position, it is for getting the correct
                    // index since the indexes given are starting with 1 (look at example picture).
                    int nextIdx = flatBoard[i] > -1 ? flatBoard[i] - 1 : i;
                    
                    // We slightly optimize the bfs process to avoid duplicates by keeping a list of visited indexes.
                    if(!visited[nextIdx]) {
                        myQueue.offer(nextIdx);
                        visited[nextIdx] = true;
                    }
                }
            }
            ++numSteps;
        }
        return -1;
    }
}
