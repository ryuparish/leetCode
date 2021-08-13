class Solution {
    int[][] dp;
    // Recursing function for dp filling
    public int findPath(String s, String t, int i, int j){
        // Base Case where we have found a solution
        if(j == t.length()){
            return 1;
        }

        // Base Case where we are at the limit of the first word
        if(i == s.length()){
            return 0;
        }
        
		// Base Case where there is a previously found path at this point.
        if(dp[i][j] != null){
            return dp[i][j];
        }

        // If it is a match, we consider it and also try disregarding it
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = findPath(s, t, i+1, j+1) + findPath(s, t, i+1, j);
            return dp[i][j];
        }
        // If there is not a match, but we haven't reached a boundary yet
        dp[i][j] = findPath(s, t, i+1, j);
        return dp[i][j];
    }
            
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return findPath(s, t, 0, 0);
    }
}
