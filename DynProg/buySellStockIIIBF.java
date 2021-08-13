// We could possilbly work backwards since we know that on the last two days, buying would get you no money in the last
// spot and only prices[prices.length()-1] dollars on the second to last day.
class Solution {
    public int transact(int[] prices, int numTrans, int position, boolean holding){
        // Base Case where we sell on the last day
        if(position == prices.length-1){
            return prices[position];
        }
        // In the case where we are out of transactions
        if(numTrans == 2){
            return 0;
        }
        // The case where we are holding and we have to buy
        if(!holding && position == prices.length - 2){
            return prices[position];
        }
        // We try selling or doing nothing if we are holding and buying or doing nothing if we are not holding.
        if(holding){
            return Math.max(prices[position] + transact(prices, numTrans+1, position+1, false), transact(prices, numTrans, position+1, true));
        }
        // If not holding then we try buying or just doing nothing
        return Math.max(transact(prices, numTrans, position+1, true) - prices[position], transact(prices, numTrans, position+1, false));
    }
    public int maxProfit(int[] prices) {
        int bestProfit = 0, currProfit;
        for(int i = 0; i < prices.length; ++i){
            currProfit = transact(prices, 0, 0, false);
            if(currProfit > bestProfit){
                bestProfit = currProfit;
            }
        }
        return bestProfit;
    }
}
