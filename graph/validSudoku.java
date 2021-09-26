// Gist: We can use 3 hashsets, each with 9 spots and containing unique values from each row, column, and grid section.
// We can then run across the whole matrix a single time and check for duplicates at each step. The calculation for
// identifying which grid section we are in is also explained below, using the column as the triple multiplier and the
// column as to which longitude we are in.
//              | | |  | | |  | | |
//              | 1 |  | 2 |  | 3 |
//              | | |  | | |  | | |
//  
//              | | |  | | |  | | |
//              | 4 |  | 5 |  | 6 |
//              | | |  | | |  | | |
//  
//              | | |  | | |  | | |
//              | 7 |  | 8 |  | 9 |
//              | | |  | | |  | | |
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        HashSet<Character>[] rowSet = new HashSet[m];
        HashSet<Character>[] columnSet = new HashSet[m];
        HashSet<Character>[] sectionSet = new HashSet[m];
        
        // Making a hashset for each column, row, and section
        for(int i = 0; i < 9; ++i){
            rowSet[i] = new HashSet<Character>();
            columnSet[i] = new HashSet<Character>();
            sectionSet[i] = new HashSet<Character>();
        }
        
        // Validating process of sudoku grid
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < m; ++j){
                char currChar = board[i][j];
                if(currChar == '.'){
                    continue;
                }
                // Checking row dupes
                if(rowSet[i].contains(currChar)){
                    return false;
                }
                rowSet[i].add(currChar);
                
                // Checking column dupes
                if(columnSet[j].contains(currChar)){
                    return false;
                }
                columnSet[j].add(currChar);
                
                // Checking the section
                // The calculationg uses the row for the vertical multiplier
                // and the column for the longitude location.
                if(sectionSet[(i/3) * 3 + j/3].contains(currChar)){
                    return false;
                }
                sectionSet[(i/3) * 3 + j/3].add(currChar);
            }
        }
        return true;
    }
}
