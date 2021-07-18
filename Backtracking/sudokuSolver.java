import java.util.*;
class Solution {
    public static int[] findNextPosition(char[][] board, int[] position){
        boolean clear = true;
        int[] newPosition = new int[2];
        for(int i = position[0]; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '.'){
                    clear = false;
                    newPosition[0] = i; newPosition[1] = j;
                    break;
                }
            }
            if(!clear){break;}
        }
        if(!clear){return newPosition;}
        // Returning invalid index if clear to activate the base case in the sudokuSolver
        newPosition[0] = board.length;
        newPosition[1] = board[0].length;
        return newPosition;
    }
        
    // We will provide a position (i,j) to help speed up the looping in search for a '.'
    public static char[][] sudokuSolver(char[][] board, int[] position){
        // If a solution was found
        if(position[1] >= board[0].length){return board;}

        // Now getting all the possible elements to choose from at this position
        Set<Character> currSet = new HashSet<Character>();

        // Adding every number from 1 - 9
        for(int i = 1; i < 10; ++i){currSet.add(Character.forDigit(i, 10));}

        // Removing all other numbers that are in the same row
        for(int i = position[0]; i < position[0]+1; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] != '.'){
                    currSet.remove(board[i][j]);
                }
            }
        }

        // Removing all other numbers that are in the same column from the set 
        for(int i = position[1]; i < position[1]+1; ++i){
            for(int j = 0; j < board.length; ++j){
                if(board[j][i] != '.'){
                    currSet.remove(board[j][i]);
                }
            }
        }

        // Removing all other numbers that are in the same block from the set 
        int rowBlock = (int)(position[0] / 3); 
        int columnBlock = (int)(position[1] / 3); 
        for(int i = rowBlock*3; i < (rowBlock*3) +3; ++i){
            for(int j = columnBlock*3; j < (columnBlock*3) +3; ++j){
                if(board[i][j] != '.'){
                    currSet.remove(board[i][j]);
                }
            }
        }

        char[][] solvedBoard = new char[board.length][board[0].length];
        for(char possibleDigit : currSet){
            board[position[0]][position[1]] = possibleDigit;
            int[] nextPosition = findNextPosition(board, position);
            solvedBoard = sudokuSolver(board,nextPosition);
            if(solvedBoard == null){
                board[position[0]][position[1]] = '.';
                continue;
            }
            else{return solvedBoard;}
        }
        // No number was found that could fit into this spot on the board with this configuration
        return null;
    }

    public void solveSudoku(char[][] board) {
        boolean clear = true;
        int[] position = new int[2];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '.'){
                    clear = false;
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
            if(!clear){break;}
        }
        if(clear){return;}
        char[][] mySolution = sudokuSolver(board, position);
        System.out.print('[');
        for(int i = 0; i < board.length; ++i){
            System.out.print('[');
            for(int j = 0; j < board[0].length; ++j){
                System.out.print('\"' + Character.toString(board[i][j]) + "\"");
                if(j + 1 < board[0].length){
                    System.out.print(',');
                }
            }
            System.out.print(']');
            if(i + 1 < board.length){
                System.out.print(',');
                System.out.println("");
            }
        }
        System.out.print(']');
        return;
    }

    public static void main(String[] args){
        Solution mySolution = new Solution();        
        char[][] myBoard = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        mySolution.solveSudoku(myBoard);
        return;
    }
}
