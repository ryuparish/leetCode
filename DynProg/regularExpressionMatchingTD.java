// Gist: We recurse down the pattern and string with two pointers and memoize each result we get.
// The tricky part is the * character. When we recurse we get the match value out of convenience and then
// we need to simulate possibly skipping the value completely if the next value is a star, or counting the
// value in the text string and staying on the letter before the star in the pattern. Finally, if no star,
// we consider continuing with moving both heads twice with recursion if they match.
// TC: O(s*p), SC: O(s*p)
class Solution {
    // Utilizing the TRUE and FALSE identifiers along with null
    enum Answer{
        TRUE, FALSE;
    }
    
    public boolean isMatch(String s, String p) {
        Answer[][] dp = new Answer[s.length()+1][p.length()+1];
        return recurseRegex(s, p, 0, 0, dp);
    }
    
    private boolean recurseRegex(String s, String p, int stringHead, int patternHead, Answer[][] dp){
        // If spot is currently memoized
        if(dp[stringHead][patternHead] != null){
            return dp[stringHead][patternHead] == Answer.TRUE;
        }
        boolean currResult;
        // If both the string and the pattern are completely finished and matched
        if(stringHead == s.length() && patternHead == p.length()){return true;}
        
        // If they are not finished recurse
        else{
            boolean match = stringHead < s.length() && patternHead < p.length() ? s.charAt(stringHead) == p.charAt(patternHead) || p.charAt(patternHead) == '.': false;
            
            // Dealing with start next
            // Simulating if the next value is a star
            if(patternHead < p.length()-1 && p.charAt(patternHead + 1) == '*'){
                currResult = recurseRegex(s, p, stringHead, patternHead + 2, dp) || match && recurseRegex(s, p, stringHead+1, patternHead, dp);
            }
            
            // Dealing with anything else
            // Simulating regular match
            else{currResult = match && recurseRegex(s, p, stringHead+1, patternHead+1, dp);}
        }
        
        // Memoize
        dp[stringHead][patternHead] = currResult ? Answer.TRUE : Answer.FALSE;
        return currResult;
    }
}
