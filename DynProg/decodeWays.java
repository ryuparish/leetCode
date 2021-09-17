// Dynamic Programming
// TC: O(n), SC: O(n)
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){return 0;}
        
        // dp is array is 1 larger than s.length() 
        int[] dp = new int[s.length() + 1];
        // I believe this is one because we are assuming there is at least 1 possible
        // path in the beginning
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        // Visualization
        // dp is also shifter left by 1 spot (i = i-1 on s)
        //   1 1 x  ... // dp array
        //     2 2 6... // s
        //   ^ ^ ^
        //       i
        
        for(int i = 2; i < dp.length; ++i){
            // The Gist is that we jump from the number before and if possible from
            // the number before that one as well, so we consider both cases.
                
                
            // If the current value is valid, then we get to the current position
            // dp[i-1] ways.
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            
            // We now consider the case where we take the digit to the left,
            // meaning we can get to the current position in dp[position-before-the-digit-to-left] number of times.
            // the-left 
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit < 27 && twoDigit > 9){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}
