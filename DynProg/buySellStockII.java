// This solution works because it simulates that we are selling a stock or many stocks to equate the 
// largest stock possible.
// The largest consecutive profit can be treated as multiple smaller stocks (prices[i] - prices[i - 1], 
// again and again until we reach a value that is smaller than the stock before it).
// When a stock is smaller that the one before it, it simulates a buy if the stock after it is larger,
// and a nothing-choice if the stock after it is smaller. 
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
