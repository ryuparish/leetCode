# Original Solution
#class Solution:
#    def singleNumber(self, nums: List[int]) -> int:
#        myCounter = Counter()
#        for number in nums:
#            if(myCounter[number] == 0):
#                myCounter[number] += 1
#            else:
#                del myCounter[number]
#        return next(myCounter.elements())
    
# Most Optimal Solution in Python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        myCounter = Counter(nums)
        for k, v in myCounter.items():
            if(v == 1): return k
