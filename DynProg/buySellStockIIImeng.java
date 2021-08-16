// The fundamental equation:
//
//                     vvvv(1)vvv  vvvvvvvvv(2)vvvvvvvvv   vvvvv(3)vvvvv  
//      dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
//      
//      1. The previous day's profit
//      2. The profit that can be made today.
//      3. The profit made on the day before we bought, which is required since we have to sell on that day in order to be empty handed on j as the day we bought.
//
// This solution is actually not fast enough. LeetCode is certainly asking for alot out of this question.
class Solution{
	public int maxProfit(int[] prices) {
	    if (prices.length == 0) return 0;
	    int[][] dp = new int[3][prices.length];
	    for (int k = 1; k <= 2; k++)  {
	        for (int i = 1; i < prices.length; i++) {
				// First initialize min as the first possible 
	            int bestDeal = prices[0];
	            for (int j = 1; j <= i; j++)
                    // Finding the minimum price and the maximum profit
                    // The name 'min' can be misleading. We are trying to find the maximum profit and the minimum price to pay for stock at the same time.
                    // prices[j] (minimize this), dp[k-1][j-1] (maximize this), in which the difference between the two is as small as possible (negatives too)
	                bestDeal = Math.min(bestDeal, prices[j] - dp[k-1][j-1]);
                // In the case that the bestDeal and today's price beat yesterday's profit, we set today's profit as the prices[i] - bestDeal.
	            dp[k][i] = Math.max(dp[k][i-1], prices[i] - bestDeal);
	        }
	    }
	    return dp[2][prices.length - 1];
	}
}

// This one works. We can remove the j for loop as it does too many repeated calculations and we only need to look at the previous day and it's transactions to
// see if there is a better profit to be made. Everything before that is old data that we chose the best of in the previous day and it's transactions. That previous day's
// transactions however, is now newly made data.
class Solution{
	public int maxProfit(int[] prices) {
	    if (prices.length == 0) return 0;
	    int[][] dp = new int[3][prices.length];
        int[] bestDeals = new int[3];
        Arrays.fill(min, prices[0]);
	    for (int i = 1; i < prices.length; i++)  {
	        for (int k = 1; k < 3; k++) {
                // Finding the minimum price and the maximum profit
                // The name 'min' can be misleading. We are trying to find the maximum profit and the minimum price to pay for stock at the same time.
                // prices[j] (minimize this), dp[k-1][j-1] (maximize this), in which the difference between the two is as small as possible (negatives too)
	            bestDeals[k] = Math.min(bestDeals[k], prices[i] - dp[k-1][i-1]);
                // In the case that the bestDeal and today's price beat yesterday's profit, we set today's profit as the prices[i] - bestDeal.
	            dp[k][i] = Math.max(dp[k][i-1], prices[i] - bestDeals[k]);
	        }
	    }
	    return dp[2][prices.length - 1];
	}
}

