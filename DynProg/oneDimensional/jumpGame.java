// Original Accepted solution
// O(n) time complexity with Theta(n) space complexity.
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] + i >= nums.length-1){
                dp[i]  = true;
            }
            else{
                for(int j = i+1; j <= i + nums[i]; ++j){
                    if(dp[j] == true){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}

// Cleaned much faster code that uses constant space and O(n) time complexity
class Solution {
    public boolean canJump(int[] nums) {
        int possibleSpot = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] + i >= possibleSpot){
                possibleSpot = i;
            }
        }
        return possibleSpot <= 0;
    }
}
