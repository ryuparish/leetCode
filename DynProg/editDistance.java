class Solution{
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // This is a Top-Down Approach
        // The spot i, j represents untyping the substrings word1[0, i] and word2[0, j] in the most efficient way possible with our given edit options. 
        // It is a representation of the optimal number of edits it takes to TRANSFORM those substrings 
        // from one to another (substring1 to substring2 or substring 2 to substring1, they will have the same edit distance).
        //
        // Basically, [i,j] is "How much it costs in terms of insertions, deletions, and/or replacements to get these
        // two substrings to be equivalent, from substring1 to substring2 or from substring2 to substring1".
        //  
        // Possible Moves:
        // Diagonal movement = either free because both are the same letter or 1 from a replacement
        // Downward movement = 1 to signify either a deletion or an insertion, which one depends on the previous decisions and
        // if no decisions have been made, either representation can be chosen.
        // Rightward movement = 1 to also signify either a deletion or an insertion, once again which one depends on the previous
        // decisions and if no decisions have been made, either representation can be chosen.
        int[][] dp = new int[m + 1][n + 1];
        // First we need to set up the initial knowledge we have about transforming 
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
				// Free due to same letter
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
