// Gist: We create an array from 0 to n and fill all but the 0th spot with amount+1. We then
// use a bottom approach starting at 1 to calculate the minimum number coins it would take to get
// to the current position, based on the spots that we could jump from behind.
// TC: O(n*numCoins), SC: O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // We have to do amount+1 in case of 0. In case of 0, the loops would not happen and then
        // the last conditional would return -1 instead of 0.
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        // We climb up to the target number and at each step upwards, we stop and look back
        // at which position to jump from, specifically the index that would give the least
        // number of coins. 
        //
        // We are utilizing the min num of coins it takes to get the numbers
        // before the amount wanted to dp.
        for(int i = 1; i <= amount; ++i){
            for(int j = 0; j < coins.length; ++j){
                if(coins[j] <= i){
                    // Keeping the largest value or jumping from the index that has the
                    // least number of coin usage
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        // We return the minimum number of coins that it takes
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
