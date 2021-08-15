// This doesn't work.
// The fundamental equation:
//                                                  vvvvvvvvvvvvvvvvvvvvvv maxDiff 
//      M[i][j] = Math.max(dp[i][j-1], prices[j] -  prices[m] + dp[i-1][m]) 
// 
public int MaxProfitDpCompact1T(int[] prices) {
    if (prices.length == 0) return 0;
    int[][] dp = new int[3][prices.length];
    int maxDiff = 0, k = 1;;
    for (int i = 1; i < prices.Length; i++) {
        for (k = 1; k < 3; k++) {
            dp[k][i] = Math.max(dp[k][i-1], prices[i] - maxDiff);
            // We want the largest maxDiff possible. 
            if(maxDiff < prices[i] - dp[k-1][i]){
                maxDiff = prices[i] - dp[k-1][i];
            }
        }
    }
    return dp[2, prices.Length - 1];
}

// Video Notes:
//      - The value of maxDiff is the going to be the largest value of (M[i-1][m], which is the previous profit with one less transaction, subtracted by the current price of the stock)
//      - When the number at M[i][j] gets larger/changes, it means that the previous days had an inferior profit compared to the current one. If the value stays the same it means the current day did not have a better profit.
//
//      What we want out of the formula:
//          M[i][j] = max{ M[i][j-1] (this is the previous day's profit), arr[j] - arr[m] + M[i-1][m] 
//              * M[i][j-1] is the previous day's profit
//              * arr[j] is the current stock price
//              * arr[m] is the stock price when the prices was the lowest whilst also having the highest profit with one less transaction.
//              * maxDiff will keep track of which day, m, had the largest profit whilst having the smallest stock price.
//
