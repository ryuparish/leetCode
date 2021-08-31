# Original Solution
# TC: O(n) SC: O(1)
#class Solution:
#    def removeDuplicates(self, nums: List[int]) -> int:
#        currCount = 0
#        currNum = nums[0]
#        lagHead = 0
#        for idx, num in enumerate(nums):
#            # If the pattern is not greater than or equal to the third duplicate,
#            # keep copying the list into lagHead's index
#            if(num == currNum and currCount < 2):
#                currCount += 1
#                nums[lagHead] = num
#                lagHead += 1
#                
#            elif(num != currNum):
#                nums[lagHead] = num
#                lagHead += 1
#                currCount = 1
#                currNum = num
#        return lagHead
                
class Solution:
# TC: O(n) SC: O(1)
    def removeDuplicates(self, nums: List[int]) -> int:
        currCount = 0
        for num in nums:
            # The index, currCount will only copy the current num and increment if the current number
            # is greater than two behind the currCount index. So it will activate always unless
            # there is the same number stretching from two behind the currCount up to the current idx.
            if(currCount < 2 or num > nums[currCount-2]):
                nums[currCount] = num
                currCount += 1
        return currCount
                
