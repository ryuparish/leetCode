// Gist:
// The tricky part is how to deal with having a zero in the top row or left column and not
// in the other. We need to avoid using the top left spot for both and separate the functionality.
// 
// Because of this, we look at the matrix in two parts: the matrix excluding the leftmost column,
// and the leftmost column:
//
// If there is a zero on the top row, we will set the top left spot to
// zero and it will set the top row to all zeroes later.
// 
// If there is a zero on the leftmost column, we will set the FLAG to be true and all the
// left column will be set to zero on the zero-setting iteration.
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        // There must be flag to indicate the how to 
        // if we didn't differentiate them. If we use a flag, we can use the top left spot
        // as a valid flag.
        boolean colZero = false;
        
        // Looking at the matrix from the top left to the bottom right
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
        
        // If we iterate backwards, we can avoid setting everything to zero on the
        // case that colZero == true.
        for(int i = m-1; i >= 0; --i){
            for(int j = n-1; j >= 1; --j){
                
                // We use or because for either one, there is zero on the column or row
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            
			// We check each time and treat the left row as it's own matrix
            if(colZero){matrix[i][0] = 0;}
        }
        return;
    }
}
