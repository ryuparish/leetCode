class Solution {
    public int maxProfit(int[] prices) {
		int[] buyingProfit = new int[prices.length];
        int bestProfit = 0;
        // Filling the max profit for buying on each day
        for(int i = 0; i < prices.length; ++i){
            int boughtPrice = prices[i];
            int bestSellingPrice = -1;
            for(int j = i + 1; j < prices.length; ++j){
                if(prices[j] > bestSellingPrice){
                    bestSellingPrice = prices[j];
                }
            }
            buyingProfit[i] = i < prices.length - 1 ? bestSellingPrice - boughtPrice : 0;
        }

        // Finding the best possible profit
        for(int i = 0; i < buyingProfit.length; ++i){
            for(int j = i + 2; j < buyingProfit.length; ++j){
                if(buyingProfit[i] + buyingProfit[j] > bestProfit){
                    bestProfit = buyingProfit[i] + buyingProfit[j];
                }
            }
        }
        return bestProfit;
    }
}
