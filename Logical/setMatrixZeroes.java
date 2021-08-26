// The idea around this solution is that since we only use the jth top row and the ith left column of the
// spot [i][j], which means the spots have already been checked and over running them with zero would be okay.
// 
// The tricky part is how to deal with having a zero in the top row or left column and not in the other.
// Because of this, we look at the matrix in four parts: the whole matrix, the top row, the left column, 
// and the whole matrix EXCLUDING the top row and the left column.
// 
// In this order: The whole matrix, the matrix excluding the top row and left column, the top row, the left
// column.
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // We need to keep a boolean in the scenario that there is a zero in the top row,
        // but no zero in the left column, which would cause the left column to be set to 0
        // if we didn't differentiate them.
        boolean colZero = false;
        // Looking at the whole matrix for the column boolean and the zero-rows/columns we will take
        // care of later.
        for(int i = 0; i < m; ++i){
            if(matrix[i][0] == 0){
                colZero = true;
            }
            for(int j = 1; j < n; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // The matrix excluding the top row and the left column
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // The top row
        if(matrix[0][0] == 0){
            for(int i = 1; i < n; ++i){matrix[0][i] = 0;}
        }
        // The left column
        if(colZero){
            for(int i = 0; i < m; ++i){matrix[i][0] = 0;}
        }
        return;
    }
}
