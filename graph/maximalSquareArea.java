// TC: O(mn) SC: O(mn)
//class Solution {
//    public int maximalSquare(char[][] matrix) {
//        // We need +1 in length to avoid segfaults. This will act as an additional
//        // row and column to allow for a "base" beginning.
//        int[][] subMatrix = new int[matrix.length+1][matrix[0].length+1];
//        int maxLength = 0;
//        for(int m = 0; m < matrix.length; ++m){
//            for(int n = 0; n < matrix[0].length; ++n){
//                if(matrix[m][n] == '1'){
//                    subMatrix[m+1][n+1] = Math.min(Math.min(subMatrix[m][n], subMatrix[m+1][n]), subMatrix[m][n+1]) + 1;
//                    maxLength = Math.max(subMatrix[m+1][n+1], maxLength);
//                }
//            }
//        }
//        return maxLength*maxLength;
//    }
//}
// TC: O(mn), SC: O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        // We use +1 so we can counter the prev variable upon starting a new row of a square.
        int[] subArray = new int[matrix[0].length+1];
        int maxLength = 0, valueToTheLeft = 0;
        for(int m = 0; m < matrix.length; ++m){
            for(int n = 0; n < matrix[0].length; ++n){
                // We use this variable to remember the previous value at this index.
                int origCurrVal = subArray[n+1];
                if(matrix[m][n] == '1'){
                    subArray[n+1] = Math.min(Math.min(subArray[n], valueToTheLeft), origCurrVal) + 1;
                    maxLength = Math.max(subArray[n+1], maxLength);
                }
                // We need to update subArray since this current index does not have a square possible.
                else{subArray[n+1] = 0;}
                valueToTheLeft = origCurrVal;
            }
        }
        return maxLength*maxLength;
    }
}
// Notes:
    // For 2D to 1D translation of indexes:
    //  2D           1D
    //  dp[i-1,j] => dp[i] [Above]
    //  dp[i,j-1] => valueToTheLeft [Left]
    //  dp[i-1,j-1] => dp[i-1] [Above and Left]
    // - Keep in mind that min(dp(i-1,j), dp(i-1,j-1), dp(i,j-1)) will return the shortest lenght of the
    //      diagonal, vertical, or horizontal side. The diagonal is included because of the properties of
    //      a square. In order to be a square, we must have the all three of the lengths listed above as the same
    //      length.
    // Roles of the integers and array:
        // dp array = To keep track of the previous row's values.
        // dp[i] = This is the spot above the current coordinate.
        // dp[i-1] = This is the spot to the top left of the previous coordinate.
        // prev = This is the spot immediately to the left of the current spot.*
        // Worries:
            // If there is a new row starting and the valueToTheLeft is not truly the value to the left.
            //      It is always the case that subArray[n] (where n is at first 0) is 0 when n = 0, so
            //      it would be impossible for the loop-around valueToTheLeft to be a problem (min is used).
