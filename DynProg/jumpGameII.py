class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        lastIdx = len(nums) - 1
        dp[lastIdx] = 0
        # Iterates backwards short of index -1 and starting from max valid index
        for idx in range(len(nums) - 2, -1, -1):
            minSteps = 10001
            # In the case that the number of steps available is 0
            if(nums[idx] == 0 and idx != lastIdx):
                dp[idx] = minSteps
                continue
            # First checking if the number of steps available can allow you to get to the goal with no
            # other steps
            if(nums[idx] + idx >= lastIdx):
                # No further steps need to be taken, just the current one
                minSteps = 1
            else:
                for stepNum in range(1, nums[idx]+1):
                    option = dp[idx + stepNum]
                    if(1 + option < minSteps):
                        minSteps = 1 + option
            dp[idx] = minSteps
        # Return the num of steps of the first index
        return dp[0]
