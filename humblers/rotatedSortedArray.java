// Gist: There is a guarantee for the array to be rotated at one point. We need to run a binary
// search that is slightly augmented on the conditionals. At any split, there will always be
// at least one side that contains a monotonically increasing set of numbers, or what I call
// the "certain" side. If the target is in that side then move to that side, if not move to 
// the other and it will be the same problem but smaller, a sub-problem. Divide and Conquer.
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1, mid, midVal;
        
        // We can allow overlap, just not exceedence
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            midVal = nums[mid];
            if(nums[mid] == target){return mid;}
            
            // When the left side if "certain"
            else if(nums[lo] <= midVal){

                // And target is in the controlled side
                if(target >= nums[lo] && midVal > target){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            
            // When the right side is "certain"
            else{
                if(target <= nums[hi] && target > midVal){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
