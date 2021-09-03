// Optimal Solution
// TC: O(n) SC: O(1)
// At most a position will be touched twice, once by the erasure and once by the loop.
class Solution {
    private void recurseIsland(int i, int j, char[][] grid){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){return;}
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            recurseIsland(i+1, j, grid);
            recurseIsland(i, j+1, grid);
            recurseIsland(i-1, j, grid);
            recurseIsland(i, j-1, grid);
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    recurseIsland(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
