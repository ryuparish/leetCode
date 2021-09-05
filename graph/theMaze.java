// Don't forget to mark them as visited!
// Gist: bfs but with queue that takes int[] and an options array
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // Defining the visited array, options array, and queue for bfs
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] options = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> myQueue = new LinkedList<int[]>();
        myQueue.offer(start);
        // bfs
        while(!myQueue.isEmpty()){
            int[] currPosition = myQueue.poll();
            if(currPosition[0] == destination[0] && currPosition[1] == destination[1]){return true;}
            for(int[] option : options){
                // Resetting position each time we consider a new option for this position
                int row = currPosition[0];
                int col = currPosition[1];
                while(row >= 0 && col >= 0 && row < maze.length && col < maze[0].length && maze[row][col] == 0 ){
                    row += option[0];
                    col += option[1];
                }
                if(maze[row - option[0]][col - option[1]] == 0 && !visited[row-option[0]][col - option[1]]){
                    int[] newSpot = {row-option[0], col-option[1]};
                    myQueue.offer(newSpot);
                    visited[newSpot[0]][newSpot[1]] = true;
                }
            }
        }
        return false;
    }
}
