// Original Attempt (Time Limit Exceeded)
// Brute Force (Solution, but Time Limit Exceeded)
//class Solution {
//    int minSum = Integer.MAX_VALUE;
//    public void findPath(int[][] grid, int currSum, int i, int j){
//        if(currSum > minSum){return;}
//        if(i == grid.length-1 && j == grid[0].length-1){
//            minSum = Math.min(currSum, minSum);
//            return;
//        }
//        if(i < grid.length-1){
//            findPath(grid, currSum + grid[i+1][j], i+1, j);
//        }
//        if(j < grid[0].length-1){
//            findPath(grid, currSum + grid[i][j+1], i, j+1);
//        }
//    }
//    public int minPathSum(int[][] grid) {
//        findPath(grid, grid[0][0], 0, 0);
//        return minSum;
//    }
//}
// Accepted Solution
//class Solution{
//    public int minPathSum(int[][] grid){
//        // dp will show the minimum price for each spot and 
//        // will allow us to do a top-down approach
//        int[][] dp = new int[grid.length][grid[0].length];
//        dp[0][0] = grid[0][0];
//        // Creating minimum price for each spot starting with the outer edge info
//        for(int i = 1; i < grid.length; ++i)
//            dp[i][0] = dp[i-1][0] + grid[i][0];
//        for(int j = 1; j < grid[0].length; ++j)
//            dp[0][j] = dp[0][j-1] + grid[0][j];
//        for(int i = 1; i < grid.length; ++i){
//            for(int j = 1; j < grid[0].length; ++j){
//                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
//            }
//        }
//        return dp[grid.length-1][grid[0].length-1];
//    }
//}
// Optimal Accepted Solution
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> pre(m, grid[0][0]);
        vector<int> cur(m, 0);
        for (int i = 1; i < m; i++)
            pre[i] = pre[i - 1] + grid[i][0];
        for (int j = 1; j < n; j++) { 
            cur[0] = pre[0] + grid[0][j]; 
            for (int i = 1; i < m; i++)
                cur[i] = min(cur[i - 1], pre[i]) + grid[i][j];
            swap(pre, cur); 
        }
        return pre[m - 1];
    }
};

