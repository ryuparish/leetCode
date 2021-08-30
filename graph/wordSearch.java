// Original Solution (Inefficient)
class Solution {
    public boolean wordDFS(char[][] board, int row, int column, String word, int currLetter){
        if(currLetter == word.length()){return true;}
        dfsBoard[row][column] = 1;
        for(int i = row-1; i <= row +1; ++i){
            for(int j = column-1; j <= column+1; ++j){
                // Checking for only adjacent values
                if(Math.abs(row - i) + Math.abs(column - j) != 1){continue;}
                // Checking for out of bounds errors
                if((i < board.length && i >= 0) && (j < board[0].length && j >= 0)){
                   // Checking if any of the surrounding letters are matching the current spot
                   if(board[i][j] == word.charAt(currLetter) && dfsBoard[i][j] == 0){
                       if(wordDFS(board, dfsBoard, i, j, word, currLetter+1)){return true;}
                   }
                }
            }
        }
        dfsBoard[row][column] = 0;
        return false;
    }
        
    public boolean exist(char[][] board, String word) {
        int[][] dfsBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == word.charAt(0)){
                    if(wordDFS(board, dfsBoard, i, j, word, 1)){return true;}
                }
            }
        }
        return false;
    }
}

// Optimal Solution using XOR to prevent duplicate counts instead of creating an additional graph(Incomplete, I missed something)
// Apparently : Using many ifs at first then recursing only if it is valid is slower than just traveling and then checking after if it is valid
class Solution {
    public boolean wordDFS(char[][] board, int row, int column, String word, int currLetter){
        if(currLetter == word.length()){return true;}
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length){return false;}
        if(board[row][column] == word.charAt(currLetter)){return false;}
        // This "char" would no longer be a valid char and would not equal any other char that would make up a word. (ASCII only goes up to 255 but java allows up to 65,000-something for some reason)
        board[row][column] ^= 256;
        // Checking if any of the surrounding letters are matching the current spot
        // Checking for only adjacent values
        boolean result = wordDFS(board, row-1, column, word, currLetter+1) || wordDFS(board, row+1, column, word, currLetter+1) || wordDFS(board, row, column-1, word, currLetter+1) || wordDFS(board, row, column+1, word, currLetter+1);
        board[row][column] ^= 256;
        return result;
    }
        
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == word.charAt(0)){
                    if(wordDFS(board, i, j, word, 1)){return true;}
                }
            }
        }
        return false;
    }
}
