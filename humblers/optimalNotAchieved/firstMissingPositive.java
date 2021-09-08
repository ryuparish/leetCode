// The idea behind this problem is to invalidate all found numbers by
// setting the value at the index of that value to a negative number.
// Then, you loop through the list until you find a positive number.
import java.lang.Math;
class Solution {
    public int firstMissingPositive(int[] nums) {
        // Validating zeros and negative numbers for second stage
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] <= 0){nums[i] = nums.length+1;}
        }
        // Invalidating all found numbers if valid stage
        int element = 0, index = 0;
		for(int i = 0; i < nums.length; ++i){
            element = Math.abs(nums[i]);
            index = element - 1;
            // If element contained was originally a negative number
            // or if it has already been marked as "Invalidated"
            if(index < nums.length && nums[index] > 0){nums[index] *= -1;}
        }
        // Searching to find the first non-negative (or first non-found index)
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){return i+1;}
        }
        return nums.length + 1;
    }
}
