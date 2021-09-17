// Gist: We can get to the current position using all the paths to get to i-1, and/or if 
// possible, we can also get to the current position using all the paths to get to i-2.

// TC: O(n), SC: O(n)
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){return 0;}
        
        // dp is array is 1 larger than s.length() 
        int[] dp = new int[s.length() + 1];
        // I believe these are one because we are assuming there is at least 1 possible
        // path in the beginning
        dp[0] = 1;
        dp[1] = 1;
        
        // Visualization
        // dp is also shifter left by 1 spot (i = i-1 on s)
        //   1 1 x  ... // dp array
        //     2 2 6... // s
        //   ^ ^ ^
        //       i
        
        for(int i = 2; i < dp.length; ++i){
            // If the current value is valid, then we can get to the current position
            // dp[i-1] ways.
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            
            // We now consider the case where we take the digit to the left,
            // meaning we can get to the current position in dp[position-before-the-digit-to-left] ways.
            // the-left 
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit < 27 && twoDigit > 9){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}
