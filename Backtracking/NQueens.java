import java.util.*;
class Solution{
    int N;
    ArrayList<List<String>> myAnswers;
    // Coverting the 2D char array into List of strings
    public List<String> createAnswer(char[][] board){
        List<String> convertedBoard = new ArrayList<String>();
        for(int i = 0; i < board.length; ++i){
            String newRow = new String(board[i]);
            convertedBoard.add(newRow);
        }
        return convertedBoard;
    }


    // Check only for the horizontally left, top left corner and the bottom left corner due to the nature of the traversal
    public boolean isValid(int row, int column, char[][] board){
        // Horizontal left
        for(int i = row, j = 0; j < column; ++j){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Bottom left
        for(int i = row, j = column; i < N && j >= 0; --j, ++i){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // Top left
        for(int i = row, j = column; i >= 0 && j >= 0; --j, --i){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
            
    public void findNQueens(int column, char[][] board){
        // Base Case of if we are past the last column or if we are on the nth column (which is illegal)
        if(column >= N){
            List<String> answerBoard = createAnswer(board);
            myAnswers.add(answerBoard);
        }
        
        for(int row = 0; row < N; ++row){
            if(isValid(row, column, board)){
                board[row][column] = 'Q';
                findNQueens(column+1, board);
                board[row][column] = '.';
            }
        }
    }

    // LeetCode version where we don't instatiate the class object(we would have to do extra work to change this.N to instantiatedClass.N)
    public List<List<String>> solveNQueens(int n){
        // Making the necessary variables global for this object
        this.N = n;
        this.myAnswers = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                board[i][j] = '.';
            }
        }
        // Solving the currenly blank board
        findNQueens(0, board);
        return myAnswers;
    }

    //public List<List<String>> solveNQueens(Solution mySolution, int n){
    //    // Making the necessary variables global for this object
    //    this.N = n;
    //    this.myAnswers = new ArrayList<List<String>>();
    //    char[][] board = new char[n][n];
    //    for(int i = 0; i < board.length; ++i){
    //        for(int j = 0; j < board[0].length; ++j){
    //            board[i][j] = '.';
    //        }
    //    }
    //    // Solving the currenly blank board
    //    mySolution.findNQueens(0, board);
    //    return this.myAnswers;
    //}

    //public static void main(String[] args){
    //    Solution mySolution = new Solution();
    //    int n = 4;
    //    List<List<String>> theAnswers = mySolution.solveNQueens(mySolution, n);
    //    System.out.println(theAnswers);
    //    return;
    //}
        
}
