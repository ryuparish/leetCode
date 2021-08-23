class Solution {
    public int recurseSolution(int[][] grid, int m, int n){
        // Base Case if the star is reached
        // or If the spot has been memoized
        if(grid[m][n] != 0){return grid[m][n];}
        
        if(n < grid[0].length-1){
            grid[m][n] = recurseSolution(grid, m, n+1);
        }
        
        if(m < grid.length-1){
            grid[m][n] += recurseSolution(grid, m+1, n);
        }
        return grid[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m-1][n-1] = 1;
        return recurseSolution(grid, 0, 0);
    }
}
