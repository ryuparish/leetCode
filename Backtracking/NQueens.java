class Solution {
    List<List<String>> output = new ArrayList<List<String>>();
    int N;
    int size;
    
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
    
    boolean isSafe (int row, int column, char[][] board) {
        int i, j;
        // Checking horizontal left to right up to the column
        for (i = 0; i < column; i ++) {
            if (board[row][i] == 'Q') return false;
        }
        // Checking from the spot to the upper left corner
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
           if (board[i][j] == 'Q')
               return false;
        // Checking from the spot to the bottom left corner
        for (i = row, j = column; j >= 0 && i < N; i++, j--)
           if (board[i][j] == 'Q')
               return false;
  
        return true;
    }
    
    
    
    void backtrack (int column, char[][] board) {
        if (column >= N) {
            output.add(createBoard(board));
            return;
        }
        // The way this works is strange in the way that it goes from row to row on only the very first column, and checks all the columns by recursion only
        // He also is able to get away by only checking the upper left and lower left because of this(nothing but dots will exist to the right at all times)
        for (int row = 0; row < N; row ++) {
            if (isSafe(row, column, board)) {
                board[row][column] = 'Q';
                backtrack(column + 1, board);
                board[row][column] = '.';
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        this.size = n;
        char[][] board = new char[size][size];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(0, board);
        
        return output;
    }
}
