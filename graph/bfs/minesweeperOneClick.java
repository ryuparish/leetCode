// Gist: If the click is on an M, then we end the game. If not, then we check for surrounding bombs first and continue
// to recurse if there are no surrounding bombs in the proximity. If we recurse, we will only queue squares that have
// and 'E' in it's place to avoid B. The important part is marking it as 'B' when you queue to avoid double queueing.
// Lessons Learned: Using int[] is always faster than using Pair when possible
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        Queue< int[] > myQueue = new LinkedList< int[] >();
        myQueue.offer(click);
        
        int[][] directions = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        while(!myQueue.isEmpty()){
            // BE CAREFUL WITH CONFUSING THE CARTESIAN (x,y) PLANE WITH 2D ARRAYS (y, x)!
            int[] currSpot = myQueue.poll();
            int horiz = currSpot[1];
            int vert = currSpot[0];
            
            // Case of revealing a mine
            if(board[vert][horiz] == 'M'){
                board[vert][horiz] = 'X';
            }
            
            else{
                // First check proximity and see if there is any bombs around to stop the queue additions
                char currChar = 'B';
                
                // Checking every direction for mines first, then checking every direction for
                // bfs.
                for(int[] direction : directions) {
                    int nextVert = vert + direction[0];
                    int nextHoriz = horiz + direction[1];
                    
                    // Making safe probe to check if it a mine
                    if(nextHoriz < n && nextHoriz > -1 && nextVert < m && nextVert > -1 && board[nextVert][nextHoriz] == 'M'){
                        // If it is a unrevealed mine
                        if(board[nextVert][nextHoriz] == 'M'){
                            currChar = currChar == 'B' ? '1' : (char)(currChar + 1);
                        }
                    }
                }
                
                board[vert][horiz] = currChar;
                if(currChar != 'B'){continue;}
                
                // Continuing bfs queue
                else{
                    // Checking every direction
                    for(int[] direction : directions) {
                        int nextVert = vert + direction[0];
                        int nextHoriz = horiz + direction[1];
                        
                        // Making safe probe to check if it a mine
                        if(nextHoriz < n && nextHoriz > -1 && nextVert < m && nextVert > -1 && board[nextVert][nextHoriz] == 'E'){
                            // Without this line, double-queueing will happen. It
                            // isn't true that the value is truly 'B', but it will deter the
                            // conditional right above from queueing again at the very least (it will always)
                            // be queued at least once.
                            board[nextVert][nextHoriz] = 'B';
                            myQueue.offer(new int[] {nextVert, nextHoriz});
                        }
                    }
                }
            }
        }
        
        return board;
    }
}
