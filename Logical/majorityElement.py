# Original Solution TC O(n) SC O(n)
#class Solution:
#    def majorityElement(self, nums: List[int]) -> int:
#        myCounter = Counter()
#        for number in nums:
#            myCounter[number] += 1
#            if myCounter[number] > len(nums)/2:
#                return number
            
# Another Solution TC O(n) SC O(1)
class Solution:
    def majorityElement(self, nums):
        count = 0
        candidate = None

        for num in nums:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)

        return candidate
