// Original Solution
// TC O(m*n)
// SC O(m*n)
//class Solution {
//public:
//    int recursePaths(std::vector< std::vector<int> >& obstacleGrid, int m, int n){
//        if(obstacleGrid[m][n] > 0){
//            return obstacleGrid[m][n];
//        }
//        if(m < obstacleGrid.size() -1 && obstacleGrid[m+1][n] > -1){
//            obstacleGrid[m][n] = recursePaths(obstacleGrid, m+1, n);
//        }
//        if(n < obstacleGrid[0].size() - 1 && obstacleGrid[m][n+1] > -1){
//            obstacleGrid[m][n] += recursePaths(obstacleGrid, m, n+1);
//        }
//        return obstacleGrid[m][n];
//    }
//    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
//        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.size()-1][obstacleGrid[0].size()-1] == 1){return 0;}
//        for(int i = 0; i < obstacleGrid.size(); ++i){
//            for(int j = 0; j < obstacleGrid[0].size(); ++j){
//                if(obstacleGrid[i][j] == 1){obstacleGrid[i][j] = -1;}
//            }
//        }
//        obstacleGrid[obstacleGrid.size()-1][obstacleGrid[0].size()-1] = 1;
//        return recursePaths(obstacleGrid, 0, 0);
//    }
//};

// Optimal Solution
// TC O(m*n) ( My solution will go over the array an additional time for the transformation )
// SC O(m*n) 
// What this code is doing is creating an overlay of the grid provided
// and turning it into a (m+1) * (n+1) dp grid that records the paths to the
// [i-1][j-1] of the grid into the [i][j] of the dp grid. It is as if grid has
// been shifted diagonally to the lower left.
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<vector<int> > dp(m + 1, vector<int> (n + 1, 0));
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (!obstacleGrid[i - 1][j - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		// For debugging
		//for(int i = 0; i < dp.size(); ++i){
        //    for(int j = 0; j < dp[0].size(); ++j){
        //        std::cout << dp[i][j] << " ";
        //    }
        //    std::cout << "\n";
        //}
        return dp[m][n];
	}
};

