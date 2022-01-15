// Gist: We mark things that will go from live to dead with a 3 and things that go from dead to alive with a -1.
// In the neighbor checking loop, we check if a neighbor is >= 1 and consider them alive if it is true.
// TC: O(mn), SC: O(1)
class Solution {
    public int[][] dirs = {{0,1}, {1,0}, {1,1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}};
    public void gameOfLife(int[][] board) {
        for(int m = 0; m < board.length; ++m){
            for(int n = 0; n < board[0].length; ++n){
                int numNeighbors = checkNeighbors(board, m, n);
                // Reproduction
                if(numNeighbors == 3 && board[m][n] == 0){
                    board[m][n] = -1;
                }
                // Under-population and over-population
                else if((numNeighbors > 3 || numNeighbors < 2) && board[m][n] == 1){
                    board[m][n] = 3;
                }
            }
        }
        for(int m = 0; m < board.length; ++m){
            for(int n = 0; n < board[0].length; ++n){
                if(board[m][n] == -1){
                    board[m][n] = 1;
                }
                else if(board[m][n] == 3){
                    board[m][n] = 0;
                }
            }
        }
    }
    
    private int checkNeighbors(int[][] board, int m, int n){
        int liveNeighbors = 0;
        for(int[] direction : this.dirs){
            if(m+direction[0] < board.length && m+direction[0] > -1 && n+direction[1] < board[0].length && n+direction[1] > -1 && board[m+direction[0]][n+direction[1]] >= 1){
                liveNeighbors++;
            }
        }
        return liveNeighbors;
    }
}
