// Original Solution
// TC: O(n^2) SC: O(n^2)
// class TicTacToe {
//    int[][] board;
//
//    /** Initialize your data structure here. */
//    public TicTacToe(int n) {
//        board = new int[n][n];
//    }
//    
//    /** Player {player} makes a move at ({row}, {col}).
//        @param row The row of the board.
//        @param col The column of the board.
//        @param player The player, can be either 1 or 2.
//        @return The current winning condition, can be either:
//                0: No one wins.
//                1: Player 1 wins.
//                2: Player 2 wins. */
//    public int move(int row, int col, int player) {
//        System.out.println(player);
//        board[row][col] = player;
//        int result = player;
//        // Checking horizonatally
//        for(int i = 0; i < board.length; ++i){
//            System.out.print("row: " + row + " col: " + i);
//            if(board[row][i] != player){result = 0; break;}
//        }
//        System.out.println("");
//        if(result != 0){return result;}
//        result = player;
//        // Checking vertically
//        for(int i = 0; i < board.length; ++i){
//            System.out.print("row: " + i + " col: " + col);
//            if(board[i][col] != player){result = 0; break;}
//        }
//        System.out.println("");
//        if(result != 0){return result;}
//        result = player;
//        // For diagonals, straight across the middle is to only way to win
//        // Checking upper left to bottom right diagonal
//        for(int i = 0; i < board.length; ++i){
//            System.out.print("row: " + i + " col: " + i);
//            if(board[i][i] != player){
//                result = 0;
//                break;
//            }
//        }
//        System.out.println("");
//        if(result != 0){return result;}
//        result = player;
//        // Checking upper right to bottom left diagonal
//        for(int i = 0; i < board.length; ++i){
//            System.out.print("row: " + i + " col: " + (board.length - (i+1)));
//            if(board[i][board.length - (i + 1)] != player){
//                result = 0;
//                break;
//            }
//        }
//        System.out.println("");
//        if(result != 0){return result;}
//        return result;
//    }
//}

// Fucking clever solution
// TC: O(1) SC: O(n)
class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antiDiagonal = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += player == 1 ? 1 : -1;
        cols[col] += player == 1 ? 1 : -1;
        if(col == row){
            diagonal += player == 1 ? 1 : -1;
        }
        if(col == (cols.length - (row+1))){
            antiDiagonal += player == 1 ? 1 : -1;
        }
        if(Math.abs(rows[row]) == rows.length || Math.abs(cols[col]) == cols.length || Math.abs(diagonal) == cols.length || Math.abs(antiDiagonal) == cols.length){return player;}
        else{return 0;}
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
