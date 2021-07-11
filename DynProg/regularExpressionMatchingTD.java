// I think they use the enum for the ability to use null and booleans only at the same time
enum Result {
    TRUE, FALSE
}

// We start at the bottom with no answer, but we recurse towards the top and bring down the answer
// (top down)
class Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        // All values in this 2D array are initially null
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    // We recurse from the bottom all the way to the top and detect for a possible chain of
    // matches which signifies a valid way to reach a success state 
    public boolean dp(int i, int j, String text, String pattern) {
        // If recursive call has been memoized already
        if (memo[i][j] != null) {
            //return memo[i][j] == Result.TRUE;
            return memo[i][j];
        }
        boolean ans;

        // Base Case for success returning "success" state. Both the pattern is processed and the
        // string has been completely matched.
        if (j == pattern.length()){
            ans = i == text.length();
        } 
        else{
            // In all of these cases, short-circuiting is used to restrict any recursive calls that
            // would include an out-of-boundaries indexing
            boolean first_match = (i < text.length()/*short circuit */ &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() /*short circuit */ && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) /*short circuit */ ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match /*short circuit */ && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
