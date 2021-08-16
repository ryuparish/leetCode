class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mylist = []
        valley = 100000
        maxProfit = 0
        for idx in range(0, len(prices)):
            if(prices[idx] < valley):
                valley = prices[idx]
            elif(prices[idx] - valley > maxProfit):
                maxProfit = prices[idx] - valley
        return maxProfit
