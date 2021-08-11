class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length - 1;
		int n = matrix[0].length - 1;
        int swapper = 0;
        for(int i = 0; i <= m/2; ++i){
            for(int j = i; j < n - i; ++j){
                swapper = matrix[i][j];
                matrix[i][j] = matrix[m-j][i]; // Swapping first with the top row (going left) and the left column (going up)
                matrix[m-j][i] = matrix[m-i][n-j]; // Swapping the left column (going up) with the bottom row (going left)
                matrix[m-i][n-j] = matrix[j][m-i]; // Swapping the bottomw row (going left) with the right column (going down)
                matrix[j][m-i] = swapper;
            }
        }
    }
    // For testing if you want
    //public void print_matrix(int[][] matrix){
    //    int m = matrix.length;
    //    int n = matrix[0].length;
    //    for(int i = 0; i < m; ++i){
    //        for(int j = 0; j < n; ++j){
    //            System.out.print(matrix[i][j] + " ");
    //        }
    //        System.out.print("\n");
    //    }
    //}
    //public static void main(String[] args){
    //    Solution mySolution = new Solution();
    //    // Base test
    //    //int[][] matrix = {{0, 1, 2, 3, 4},
    //    //                 {5, 6, 7, 8, 9},
    //    //                 {10, 11, 12, 13, 14},
    //    //                 {15, 16, 17, 18, 19},
    //    //                 {20, 21, 22, 23, 24}};
    //    int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    //    mySolution.print_matrix(matrix);
	//	System.out.print("\n");
    //    mySolution.rotate(matrix);
    //    mySolution.print_matrix(matrix);
    //}
}
