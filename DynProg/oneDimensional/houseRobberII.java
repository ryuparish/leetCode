// Gist: The important difference between this and the first version is the fact that we
// can only use 0th to n-2 or 1th to n-1, and not 0th to n-1. 
class Solution {
    
    public int rob(int[] nums) {
        if(nums.length == 0){return 0;}
        if(nums.length == 1){return nums[0];}
        int length = nums.length;
        
        // Modified recurrence relation
        // Since we look 2 spots back from the end, we send length-3 and 2
        return Math.max(robHouse1(nums, 0, length-2), robHouse1(nums, 1, length-1));
    }
    
    private int robHouse1(int[] nums, int start, int end){
        // This is will always be the same for both initialization due to the way we assign
        // ie. curr = nums[end] saves the day.
        int prev = nums[end], doublePrev = 0, curr = nums[end];
        
        // end -1 is really length-2
        for(int i = end - 1; i >= start; --i){
            curr = Math.max(nums[i] + doublePrev, prev);
            
            // Increment the following pointers
            // Order of assignment matters!!
            doublePrev = prev;
            prev = curr;
        }
        return curr;
    }
}
