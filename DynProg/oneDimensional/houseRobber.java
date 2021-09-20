// Gist: We can either choose the current index that we are on to add to the sum, or we can move
// onto the next house and make the same decision. This is the recurrence relation. 

// We can easily do this forwards with a recursive/dp approach but approaching the same idea
// whilst looping backwards will be more efficient due to the fact that I will only have to
// look at two spots every time the current of the one in front(which was just calculated
// beforehand and dp'd)

// dp
// TC: O(n), SC: O(n)
//class Solution {
//    public int rob(int[] nums) {
//        if(nums.length == 0){return 0;}
//        int maxLength = nums.length;
//        // We need to initialize dp-ization array
//        // We add an additional zero at the end to avoid the segfault in the first iteration
//        // ie. dp[i+2]
//        int[] dp = new int[maxLength + 1];
//        dp[maxLength] = nums[maxLength];
//        dp[maxLength-1] = nums[maxLength-1];
//        
//        // Dynamic programming backwards // Note that this works for length 1,2 edge cases
//        for(int i = maxLength-2; i >= 0; --i){
//            
//            // Either carrying the earlier max or new max and memoizing
//            int spotMax = Math.max(nums[i] + dp[i+2], dp[i+1]);
//            dp[i] = spotMax;
//        }
//        return dp[0];
//    }
//}

// Space-Optimized dp. ie. We can just keep the previous value and update as necessary
// TC: O(n), SC: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){return 0;}
        int maxLength = nums.length;
        
        // We need to initialize dp-ization array
        int prev = nums[maxLength-1];
        int doubleprev = 0, curr = nums[maxLength-1];
        
        // Dynamic programming backwards // Note that this works for length 1,2 edge cases
        for(int i = maxLength-2; i >= 0; --i){
            
            // Either carrying the earlier max or new max
            curr = Math.max(nums[i] + doubleprev, prev);
            
            // Incrementing pointers
            doubleprev = prev;
            prev = curr;
        }
        return curr;
    }
}
