// We start at the bottom with no answer, but we recurse towards the top and bring down the answer
// (top down)
class Solution{
    enum Result {
        TRUE, FALSE
    }
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    // We recurse from the bottom all the way to the top and detect for a possible chain of
    // matches which signifies a valid way to reach a success state 
    public boolean dp(int i, int j, String text, String pattern) {
        // If recursive call has been memoized already (This is where the enum comes in handy rather than boolean[][] memo which auto defaults to false)
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
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
            
            // If the text has not been completely matched and the pattern matches with the current letter on the text
            // This provides information of both the chance that the string is completely matched while the pattern is not finished(send false)
            // or if the pattern and text do match, or even if they don't match.
            boolean first_match = (i < text.length()/*short circuit */ &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '?' || pattern.charAt(j) == '*'));

            // Exploration of asterisk options by recursing
            // Conditional covers if the current character is a star and branches out recursion with the two possible paths
            if (j < pattern.length() /*short circuit */ && pattern.charAt(j) == '*'){
                // Either skip asterisk or count the current letter as part of the asterisk match
                ans = (dp(i, j+1, text, pattern) /*short circuit */ ||
                       first_match && dp(i+1, j, text, pattern));
            }
            // Just continuing the matching if possible or concluding as false
            // Conditional covers if the letters were a match or a question mark and can continue, or was not a match and cannot continue
            else {
                ans = first_match /*short circuit */ && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args){
        Solution mySolution = new Solution();
        String myText = "aa";
        String myPattern = "*";
        boolean myAnswer = mySolution.isMatch(myText, myPattern);
        System.out.println(myAnswer);
        return;
    }
}
