# This is easiest for me to understand in terms of previous substring distance costs and alignment. # The question of, "What is the minimum edit distance for substring above and substring to the left?" # can be transformed into "What is a optimal previous substring state to add my cost, the cost of # making the new letters or appendage into the same new letters or the same appendage? # Each time we move to a new spot, we are aligning two letters or a new letter and the lack of another # letter. This means the following:
# 1. If the newly aligned letters are the same, it doesn't cost anything. Use the minimally costing
# previous substring state.
# 2. If the newly align letters are not the same, it costs 1.
# 3. If the newly aligned slots have a missing letter, it costs 1.
def levenshteinDistance(str1, str2):
    # Movement to the right/down means adding a letter
    dpArray = [[0] * (len(str2)+1) for _ in range(len(str1)+1)]

    # Fill out our base cases
    for idx in range(len(str1)+1):
        dpArray[idx][0] = idx
    for idx in range(len(str2)+1):
        dpArray[0][idx] = idx

    # Fill out all the cases using the solutions for previous substring cases
    for row in range(1, len(str1)+1):
        for col in range(1, len(str2)+1):
            str1Idx = row-1
            str2Idx = col-1
            if str1[str1Idx] == str2[str2Idx]:
                dpArray[row][col] = min(dpArray[row-1][col]+1, dpArray[row][col-1]+1, dpArray[row-1][col-1])
            else:
                dpArray[row][col] = min(dpArray[row-1][col]+1, dpArray[row][col-1]+1, dpArray[row-1][col-1]+1)
    return dpArray[len(str1)][len(str2)]


#class Solution{
#    public int minDistance(String word1, String word2) {
#        int m = word1.length(), n = word2.length();
#        // This is a Top-Down Approach
#        // The spot i, j represents untyping the substrings word1[0, i] and word2[0, j] in the most efficient way possible with our given edit options. 
#        // It is a representation of the optimal number of edits it takes to TRANSFORM those substrings 
#        // from one to another (substring1 to substring2 or substring 2 to substring1, they will have the same edit distance).
#        //
#        // Basically, [i,j] is "How much it costs in terms of insertions, deletions, and/or replacements to get these
#        // two substrings to be equivalent, from substring1 to substring2 or from substring2 to substring1".
#        //  
#        // Possible Moves:
#        // Diagonal movement = either free because both are the same letter or 1 from a replacement
#        // Downward movement = 1 to signify either a deletion or an insertion, which one depends on the previous decisions and
#        // if no decisions have been made, either representation can be chosen.
#        // Rightward movement = 1 to also signify either a deletion or an insertion, once again which one depends on the previous
#        // decisions and if no decisions have been made, either representation can be chosen.
#        int[][] dp = new int[m + 1][n + 1];
#        // First we need to set up the initial knowledge we have about transforming 
#        for (int i = 1; i <= m; i++) dp[i][0] = i;
#        for (int j = 1; j <= n; j++) dp[0][j] = j;
#        for (int i = 1; i <= m; i++) {
#            for (int j = 1; j <= n; j++) {
#				// Free due to same letter
#                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
#                    dp[i][j] = dp[i - 1][j - 1];
#                } else {
#                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
#                }
#            }
#        }
#        return dp[m][n];
#    }
#}
